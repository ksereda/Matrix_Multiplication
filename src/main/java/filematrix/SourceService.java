package filematrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static filematrix.FileService.operationWithFile;

public class SourceService {

    static double[][] readMainFile(String fileName) throws IOException {

        return operationWithFile(fileName);

    }

    static List<String> findNumberFiles() throws IOException {

        List<String> listNumberFiles = new ArrayList<>();

        BufferedReader mainFile = new BufferedReader(new FileReader("mainfile.txt"));
        String line;

        while ((line = mainFile.readLine()) != null) {
            listNumberFiles.add(line);
        }

        return listNumberFiles;

    }

}
