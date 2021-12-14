package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputViewUtil {
    // Do not initialize
    private InputViewUtil() {
    }

    public static String userInput() {
        return new Scanner(System.in).nextLine()
                .trim()
                .toLowerCase();
    }

    public static <T> List<T> asList(T[] array) {
        return Arrays.asList(array);
    }

    public static String StringPadding(String elem) {
        return String.format("%-6s", elem);
    }
}
