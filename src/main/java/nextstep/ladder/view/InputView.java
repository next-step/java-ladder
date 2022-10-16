package nextstep.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_DEFAULT_DELIMITER = ",";
    private static final String INPUT_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static String[] inputNames() {
        return inputWithText(INPUT_PLAYER_NAMES_MESSAGE).split(INPUT_DEFAULT_DELIMITER);
    }

    public static String[] inputResults() {
        return inputWithText(NEW_LINE + INPUT_RESULTS_MESSAGE).split(INPUT_DEFAULT_DELIMITER);
    }

    public static int inputLadderHeight() {
        try {
            return Integer.parseInt(inputWithText(NEW_LINE + INPUT_LADDER_HEIGHT_MESSAGE));
        } catch (NumberFormatException e) {
            System.out.println(INPUT_NUMBER_MESSAGE);
            return inputLadderHeight();
        }
    }

    private static String inputWithText(String text) {
        System.out.println(text);
        return input();
    }

    private static String input() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
