package ladder.util;

import java.util.Scanner;

import static ladder.Messages.WARNING_NOT_NUMBER_TYPE;
import static ladder.Messages.WARNING_NULL_OR_EMPTY;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        String input = readLine();
        validateIntegerType(input);
        return Integer.parseInt(input);
    }

    public static String readLine() {
        String input = scanner.nextLine();
        validateNullOrEmpty(input);
        return input;
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARNING_NOT_NUMBER_TYPE);
        }
    }

    private static void validateNullOrEmpty(String input) {
        if (input.isEmpty() || input == null) {
            throw new IllegalArgumentException(WARNING_NULL_OR_EMPTY);
        }
    }
}