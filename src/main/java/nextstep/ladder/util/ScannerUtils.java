package nextstep.ladder.util;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static int nextInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

}
