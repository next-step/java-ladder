package nextstep.ladder.step4.utils;

import java.util.Scanner;

public class ScannerUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ScannerUtil() {
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static int nextInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

}
