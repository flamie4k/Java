package lutput.catMath;

public class peaklutputgiri {
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculate(n - 1);
        }
    }
}
