package ladder.view;

import ladder.dto.LadderGameRequest;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PLAYER_NAME_SEPARATOR = ",";

    public static LadderGameRequest ladderGameRequest() {
        return new LadderGameRequest(playerNameList(),ladderHeight());
    }

    private static String[] playerNameList() {
        System.out.println(MessageConstant.PLAYER_NAME_INPUT);
        return SCANNER.nextLine().trim().split(PLAYER_NAME_SEPARATOR);
    }

    private static int ladderHeight() {
        System.out.println(MessageConstant.LADDER_HEIGHT_INPUT);
        String heightInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(heightInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return ladderHeight();
        }
    }

    public static void printWrongInputMessage() {
        System.out.println(MessageConstant.WRONG_INPUT);
    }

}
