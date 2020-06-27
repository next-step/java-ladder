package step4.view;

import step4.domain.Player;
import step4.domain.Players;
import step4.domain.WinningPrizes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYER_NANMES = "Input players name (separate : , )  : ";
    private static final String INPUT_PLAY_RESULT = "Input play winning prize (separate : , )  : ";
    private static final String INPUT_MAXIMUM_HEIGHT = "Input ladder's height : ";
    private static final String INPUT_PLAYER_WHO_WINNING = "Who do you want know winning player? (exit: quit)";
    private static final String STRING_DELIMITER = ",";
    public static final String EXIT_KEY = "quit";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players createPlayers() {
        System.out.println(INPUT_PLAYER_NANMES);
        String inputNameString = SCANNER.next();
        if (inputNameString.length() == 0) {
            throw new IllegalArgumentException();
        }
        List<Player> players = new ArrayList<>();
        Arrays.asList(inputNameString.split(STRING_DELIMITER)).forEach(x -> players.add(new Player(x)));
        return new Players(players);
    }

    public static WinningPrizes createWinningPrizes() {
        System.out.println(INPUT_PLAY_RESULT);
        String inputWinningPrize = SCANNER.next();
        List<String> winningPrizes = new ArrayList<>();
        Arrays.asList(inputWinningPrize.split(STRING_DELIMITER)).forEach(x -> winningPrizes.add(x));
        return new WinningPrizes(winningPrizes);
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_MAXIMUM_HEIGHT);
        return SCANNER.nextInt();
    }

    public static String inputNameWhoWinning() {
        System.out.println(INPUT_PLAYER_WHO_WINNING);
        return SCANNER.next();
    }

}
