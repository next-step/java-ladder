package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUser() {
        System.out.println(Message.USER);
        return scanner.nextLine();
    }

    public static int getHeight() {
        System.out.println(Message.HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
