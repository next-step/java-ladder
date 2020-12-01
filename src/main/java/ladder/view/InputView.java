package ladder.view;

import ladder.domain.LadderErrorMessage;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String MAX_HEIGHT_PATTERN = "(\\d+)";


    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputPlayerNames(){
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);
        return splitPlayerNames(scanner.next());
    }

    private static String[] splitPlayerNames(String playerNames) {
        return playerNames.split(PLAYER_NAME_DELIMITER);
    }

    public static int inputLadderHeight(){
        System.out.println(INPUT_MAX_HEIGHT_MESSAGE);
        String ladderHeightValue = scanner.next();

        validateLadderHeight(ladderHeightValue);

        return Integer.parseInt(ladderHeightValue);
    }

    private static void validateLadderHeight(String ladderHeightValue) {
        if(!ladderHeightValue.matches(MAX_HEIGHT_PATTERN)){
            throw new IllegalArgumentException(LadderErrorMessage.ILLEGAL_MAX_HEIGHT.getErrorMessage());
        }
    }
}
