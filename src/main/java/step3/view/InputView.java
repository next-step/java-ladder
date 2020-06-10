package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYER_NANMES = "Input players name (separate : , )  : ";
    private static final String INPUT_PLAY_RESULT = "Input play winning prize (separate : , )  : ";
    private static final String INPUT_MAXIMUM_HEIGHT = "Input ladder's height : ";
    private static final String STRING_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputPlayerName() {
        System.out.println(INPUT_PLAYER_NANMES);
        String inputNameString = SCANNER.next();
        return inputNameString.split(STRING_DELIMITER);
    }

    public static String[] inputWinningPrize() {
        System.out.println(INPUT_PLAY_RESULT);
        String inputWinningPrize = SCANNER.next();
        return inputWinningPrize.split(STRING_DELIMITER);
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_MAXIMUM_HEIGHT);
        return SCANNER.nextInt();
    }

    public static String inputNameWhoWinning() {
        System.out.println(INPUT_PLAY_RESULT);
        return SCANNER.next();
    }

}
