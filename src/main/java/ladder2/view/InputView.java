package ladder2.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInteger(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
