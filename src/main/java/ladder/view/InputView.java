package ladder.view;

import java.util.Scanner;

public class InputView {
    public static String inputPlayers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.useDelimiter(",").nextLine();
    }

    public static int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
