package filematrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static final String ZIPFILE = "/home/prog5/Documents/folder3/zipfiles/mainZipFile.zip";

    public static void createZip( Map<String, double[][]> map) throws IOException {

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(new File(ZIPFILE)));


        for (Map.Entry<String, double[][]> pair : map.entrySet()) {
            StringBuilder text = new StringBuilder();
            System.out.println(pair.getKey() + " " + Arrays.deepToString(pair.getValue()));

            for (int i = 0; i < (pair.getValue().length); i++) {
                String s = "";
                s = Arrays.toString(pair.getValue()[i]);
                text.append(s).append("\n");
            }

            ZipEntry zipEntry = new ZipEntry(pair.getKey());
            zipOut.putNextEntry(zipEntry);
            zipOut.write(text.toString().getBytes());
            zipOut.flush();

            zipOut.closeEntry();
        }
        zipOut.close();

    }

}

