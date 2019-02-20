package filematrix;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import static filematrix.SourceService.findNumberFiles;
import static filematrix.SourceService.readMainFile;
import static filematrix.Zip.createZip;


public class Main implements Callable<double[][]> {

    private static CountDownLatch latch;
    private static String fileName;

    public Main(CountDownLatch latch, String s) {
        this.latch = latch;
        this.fileName = s;
    }

    @Override
    public double[][] call() throws IOException {
        return readMainFile(fileName);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        Map<String, double[][]> map = new ConcurrentHashMap<>();
        List<Future<double[][]>> resultList = new ArrayList<>();

        List<String> filesNames = findNumberFiles();

        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (String filesName : filesNames) {
            Future<double[][]> future = executor.submit(new Main(latch, filesName));
            resultList.add(future);
        }

        for (int i = 0; i < resultList.size(); i++) {
            map.put(filesNames.get(i), resultList.get(i).get());
        }

        createZip(map);
        executor.shutdown();

    }

}
