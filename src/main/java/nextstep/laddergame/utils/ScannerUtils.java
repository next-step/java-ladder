package nextstep.laddergame.utils;

import java.util.Scanner;

import nextstep.laddergame.exception.InvalidScannerInputException;

public final class ScannerUtils {

    private ScannerUtils() {
    }

    public static int nextInt() {
        Scanner scanner = new Scanner(System.in);
        validateNextIntOrThrow(scanner);
        int input = scanner.nextInt();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        return input;
    }

    private static void validateNextIntOrThrow(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new InvalidScannerInputException("input is not a numeric string.");
        }
    }

    public static String nextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
