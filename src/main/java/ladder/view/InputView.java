package ladder.view;

import ladder.context.PrintMessage;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String inputGamePlayers() {
        System.out.println(PrintMessage.GAME_PLAYER.getMessage());
        return scanner.nextLine();
    }

    public static int inputLadderSize() {
        System.out.println(PrintMessage.LADDER_SIZE.getMessage());
        return scanner.nextInt();
    }
}
