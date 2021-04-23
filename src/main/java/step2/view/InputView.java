package step2.view;

import static step2.view.Message.RESULT;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUsers() {
        System.out.println(Message.USER);
        return scanner.nextLine();
    }

    public static int getHeight() {
        System.out.println(Message.HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getPrizes() {
        System.out.println(Message.PRIZE);
        return scanner.nextLine();
    }

    public static String getUser() {
        System.out.println(RESULT);
        return scanner.nextLine();
    }
}
