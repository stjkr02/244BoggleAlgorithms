import org.junit.Test;

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
        ArrayList al = RandomStringGenerator.generateArray(1);
        assertEquals(1, al.size());
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