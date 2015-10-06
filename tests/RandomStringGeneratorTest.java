import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class RandomStringGeneratorTest {
    @Test
    public void testEmptyArray() {
        ArrayList al = RandomStringGenerator.generateArray(0);
        assertEquals(0, al.size());
    }

    @Test
    public void test1(){
        ArrayList al = RandomStringGenerator.generateArray(1L);
        assertEquals(1L, al.size());
    }

    @Test
    public void test15mil() {
        ArrayList al = RandomStringGenerator.generateArray(15000L);
        assertEquals(15000L, al.size());
    }

    @Test
    public void testOutput() throws Exception {
        String filename = "testOutput.dat";

        try {
            RandomStringGenerator.outputToFile(RandomStringGenerator.generateArray(1000L), filename);

            ArrayList<String> al = new ArrayList<>();
            try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = in.readLine()) != null) {
                    al.add(line);
                }
            }

            assertEquals(1000, al.size());

        } finally {
            Files.delete(FileSystems.getDefault().getPath(filename));
        }

    }

    /* @Test
    public void testPrint(){
        ArrayList al = RandomStringGenerator.generateArray(1000);
        assertEquals(1000, al.size());

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

    }

    @Test
    public void testPrint2(){
        ArrayList al = RandomStringGenerator.generateArray(1000, 3);
        assertEquals(1000, al.size());

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

    } */
}