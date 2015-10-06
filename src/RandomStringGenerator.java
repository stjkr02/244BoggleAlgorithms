import java.util.ArrayList;
import java.util.Random;

public class RandomStringGenerator {
    private static Random r = new Random();

    public static ArrayList generateArray(long numStrings){
        ArrayList<String> al = new ArrayList<>();

        for (long i = 0; i < numStrings; i++) {
            int length = r.nextInt(27) + 1;

            StringBuilder sb = new StringBuilder(length);

            for (int j = 0; j < length; j++) {
                sb.append((char) (r.nextInt(25) + 97));
            }

            al.add(sb.toString());
        }

        return al;
    }

    public static ArrayList generateArray(long numStrings, int prefixLength){
        ArrayList<String> al = new ArrayList<>();

        for (long i = 0; i < numStrings; i++) {

            StringBuilder sb = new StringBuilder(prefixLength);

            for (int j = 0; j < prefixLength; j++) {
                sb.append((char) (r.nextInt(25) + 97));
            }

            al.add(sb.toString());
        }

        return al;
    }
}
