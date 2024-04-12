package view;

import util.StringUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    public static final String LADDER_HEIGHT_RANGE_OVER = "1 이상의 정수만 입력할 수 있습니다.";
    public static final String TRY_INPUT_AGAIN = " 다시 입력해주세요.";
    public static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력할 수 있습니다.";
    public static final String PLAY_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_DELIMITER = ",";
    public static final int MIN_LADDER_HEIGHT = 1;
    public static final String WRONG_RESULTS_INPUT = "잘못 입력하셨습니다. Player 수에 맞게 다시 입력해주세요.";

    public List<String> inputPlayers() {
        System.out.println(PLAYER_NAME_INPUT_MESSAGE);
        return StringUtil.splitStringToList(SCANNER.nextLine(), INPUT_DELIMITER);
    }

    public int inputLadderHeight() {
        return inputLadderHeight(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
    }

    private int inputLadderHeight(String message) {
        System.out.println(message);
        try {
            return scanLadderHeight();
        } catch (NumberFormatException e) {
            return inputLadderHeight(NUMBER_FORMAT_EXCEPTION + TRY_INPUT_AGAIN);
        } catch (IllegalArgumentException e) {
            return inputLadderHeight(e.getMessage() + TRY_INPUT_AGAIN);
        }
    }

    private static int scanLadderHeight() {
        int inputInt = Integer.parseInt(SCANNER.nextLine());
        if (inputInt < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_RANGE_OVER + TRY_INPUT_AGAIN);
        }
        return inputInt;
    }

    public List<String> inputResults(int playerSize) {
        return inputResults(PLAY_RESULT_INPUT_MESSAGE, playerSize);
    }

    private List<String> inputResults(String message, int playerSize) {
        System.out.println(message);
        try {
            return validatedResultList(playerSize);
        } catch (IllegalArgumentException e) {
            return inputResults(e.getMessage() + TRY_INPUT_AGAIN, playerSize);
        }
    }

    private static List<String> validatedResultList(int playerSize) {
        List<String> results = StringUtil.splitStringToList(SCANNER.nextLine(), INPUT_DELIMITER);
        if (results.size() != playerSize) {
            throw new IllegalArgumentException(WRONG_RESULTS_INPUT);
        }
        return results;
    }

    public static String readNextLine() {
        return SCANNER.nextLine();
    }

}
