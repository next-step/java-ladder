package nextstep.step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readLadderHeitht(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public static String[] readNames(String msg) {
        System.out.println(msg);
        String input = scanner.next();
        return input.split(",");
    }
}
