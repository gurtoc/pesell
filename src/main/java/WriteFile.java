import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public boolean lengthArray(String s, String s2) throws IOException {

        File file1 = new File(s);
        File file2 = new File(s2);
        File file3 = new File("test3.txt");

        boolean compare1and2 = FileUtils.contentEquals(file1, file2);
       // boolean compare2and3 = FileUtils.contentEquals(file2, file3);
        //boolean compare1and3 = FileUtils.contentEquals(file1, file3);

        System.out.println("Are test1.txt and test2.txt the same? " + compare1and2);
        //System.out.println("Are test2.txt and test3.txt the same? " + compare2and3);
       // System.out.println("Are test1.txt and test3.txt the same? " + compare1and3);
        return true;

    }

    public FileWriter saveFile() throws IOException {
        File filePath = File.createTempFile("out_", ".txt", new File("C:/Users/tom/Desktop/"));
        FileWriter fileWriter = new FileWriter(filePath, true);

        return fileWriter;
    }


}
