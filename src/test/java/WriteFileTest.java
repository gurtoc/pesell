import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WriteFileTest {

    @Test
    public void writeFile() throws IOException {
        WriteFile writeFile = new WriteFile();

        boolean test = writeFile.lengthArray("\u202AC:\\Users\\tom\\Desktop\\out_6688019594991119851.txt","\u202AC:\\Users\\tom\\Desktop\\out_15600851737134300105.txt");

        assertTrue(test);
    }
}