package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_SCORES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String FIND_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";

    private InputView() {
    }

    public static String inputString() {
        return SCANNER.nextLine();
    }

    public static int inputInteger() {
        return Integer.parseInt(inputString());
    }

    public static int inputMaxHeight() {
        ResultView.println(INPUT_MAX_HEIGHT_MESSAGE);
        return inputInteger();
    }

    private static List<String> inputList(String message) {
        ResultView.println(message);
        String input = inputString();
        return List.of(input.split(COMMA));
    }

    public static String inputName() {
        ResultView.println(FIND_RESULT_MESSAGE);
        String name = InputView.inputString();
        ResultView.println();
        return name;
    }

    public static List<String> inputNames() {
        return inputList(INPUT_NAMES_MESSAGE);
    }

    public static List<String> inputScores() {
        return inputList(INPUT_SCORES_MESSAGE);
    }
}
