package step2.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getPlayers() {
        return scanner.nextLine();
    }

    public static int getLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
