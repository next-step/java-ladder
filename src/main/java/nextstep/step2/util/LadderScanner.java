package nextstep.step2.util;

import java.util.Scanner;

public class LadderScanner {
    private static Scanner sc = new Scanner(System.in);

    public static int inputNumber() {
        return sc.nextInt();
    }

    public static String inputString() {
        return sc.nextLine();
    }

    private static void removeNewLine() {
        sc.nextLine();
    }
}
