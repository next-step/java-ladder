package ladder.view;

import ladder.domain.LadderGameErrorMessage;
import java.util.Arrays;
import java.util.Scanner;
import static ladder.domain.LadderGameConfig.PLAYER_NAME_MAX_LENGTH;

public class InputView {

    private static final String INPUT_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String MAX_HEIGHT_PATTERN = "(\\d+)";


    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputPlayerNames(){
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);

        return splitPlayerNames(scanner.next());
    }

    private static String[] splitPlayerNames(String playerNamesValue) {
        String[] playerNames = playerNamesValue.split(PLAYER_NAME_DELIMITER);

        validatePlayerName(playerNames);

        return playerNames;
    }

    private static void validatePlayerName(String[] playerNames) {
        boolean matched = Arrays.stream(playerNames)
                .anyMatch(playerName -> playerName.length() > PLAYER_NAME_MAX_LENGTH);

        if(matched){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_PLAYER_NAME.getErrorMessage());
        }

    }

    public static int inputLadderHeight(){
        System.out.println(INPUT_MAX_HEIGHT_MESSAGE);
        String ladderHeightValue = scanner.next();

        validateLadderHeight(ladderHeightValue);

        return Integer.parseInt(ladderHeightValue);
    }

    private static void validateLadderHeight(String ladderHeightValue) {
        if(!ladderHeightValue.matches(MAX_HEIGHT_PATTERN)){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_HEIGHT.getErrorMessage());
        }
    }
}
