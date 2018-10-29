import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * simple test class
 */
public class SimpleTest {

    @Test
    public void simple(){

    }

    public static int findLongest(int[] numbers) {
        for (int i : numbers) {
            String s = String.valueOf(i);
            String[] arr =s.split("");
            Set<String> set = new HashSet<String>();
            for (String anArr : arr) {
                set.add(anArr);
            }
            if (set.size()<arr.length) return i;
        }
        return  0;
    }


}
