package tema2;

import java.util.Arrays;
import static tema2.TestArrayReverse.reverse;

public class StackAplicationTest {
    public static void main(String args[]) {
    Integer[] a = {4, 8, 15, 16, 23, 42};  
    String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
    System.out.println("a = " + Arrays.toString(a));
    System.out.println("s = " + Arrays.toString(s));
    System.out.println("Reversing...");
    reverse(a);
    reverse(s);
    System.out.println("a = " + Arrays.toString(a));
    System.out.println("s = " + Arrays.toString(s));
}

}
