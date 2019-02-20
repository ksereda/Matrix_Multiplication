package filematrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static filematrix.MatrixService.matrixMultiplication;

public class FileService {

    static double[][] operationWithFile(String fileName) throws IOException {

        List<double[]> m1 = new ArrayList<>();
        List<double[]> m2 = new ArrayList<>();

        BufferedReader bufferedReaderCurrentFile = new BufferedReader(new FileReader(fileName));

        String fileLine;
        List<String> list = new ArrayList<>();

        while ((fileLine = bufferedReaderCurrentFile.readLine()) != null) {
            list.add(fileLine);
        }

        String[] stringArr = list.toArray(new String[0]);

        int index = 0;
        boolean flag = false;
        for (String s : stringArr) {
            index++;
            if (s.isEmpty()) {
                flag = true;
            } else if (flag) {
                String[] splitedLine = s.split(" ");
                double[] values2 = new double[splitedLine.length];
                for (int i = 0; i < splitedLine.length; i++) {
                    values2[i] = Double.valueOf(splitedLine[i]);
                }
                m2.add(values2);
            } else {
                String[] splitedLine = s.split(" ");
                double[] values = new double[splitedLine.length];
                for (int i = 0; i < splitedLine.length; i++) {
                    values[i] = Double.valueOf(splitedLine[i]);
                }
                m1.add(values);
            }
        }

        double[][] m1Processed = new double[m1.size()][m1.get(0).length];
        for (int i = 0; i < m1.size(); i++) {
            m1Processed[i] = m1.get(i);
        }
        System.out.println(Arrays.deepToString(m1Processed));

        double[][] m2Processed = new double[m2.size()][m2.get(0).length];
        for (int i = 0; i < m2.size(); i++) {
            m2Processed[i] = m2.get(i);
        }
        System.out.println(Arrays.deepToString(m2Processed));

        return matrixMultiplication(m1Processed, m2Processed);

    }

}
