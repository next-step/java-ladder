package ladder.view;

import ladder.dto.LadderGameRequest;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String INPUT_SEPARATOR = ",";

    public static LadderGameRequest ladderGameRequest() {
        try {
            return new LadderGameRequest(playerNameList(), prizeList(), ladderHeight());
        } catch (IllegalArgumentException ex) {
            printWrongInputMessage();
            return ladderGameRequest();
        }
    }

    public static String playerName() {
        System.out.println(MessageConstant.PLAYER_NAME_TO_PLAY_INPUT);
        return SCANNER.nextLine()
                .trim();
    }

    private static String[] playerNameList() {
        System.out.println(MessageConstant.PLAYER_NAME_INPUT);
        return SCANNER.nextLine()
                .trim().split(INPUT_SEPARATOR);
    }

    private static int ladderHeight() {
        System.out.println(MessageConstant.LADDER_HEIGHT_INPUT);
        return intInput();
    }

    private static String[] prizeList() {
        System.out.println(MessageConstant.PRIZE_INPUT);
        return SCANNER.nextLine()
                .trim().split(INPUT_SEPARATOR);
    }

    private static int intInput() {
        String inputInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(inputInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return intInput();
        }
    }

    public static void printWrongInputMessage() {
        System.out.println(MessageConstant.WRONG_INPUT);
    }


}
