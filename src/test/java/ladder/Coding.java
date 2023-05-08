package ladder;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Coding {
    public int sumOfMultiples(int nn) {
        return IntStream.rangeClosed(1, n)
                .filter(n -> (n % 7 == 0 || n % 5 == 0 || n % 3 == 0))
                .sum();
    }

    public static void main(String[] args) {
        Coding coding = new Coding();
        coding.sumOfMultiples(7);
    }
}
