package ladder.view;

import java.util.Scanner;

import static ladder.view.ResultView.RESULT_REGEX;

public class InputView {
    public static final String NAME_REGEX = ",";
    public static final String MSG_INPUT_CANDIDATE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MSG_INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String MSG_INPUT_EXECUTION_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String MSG_INPUT_RESULT_CANDIDATE_NAME = "결과를 보고싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCandidateNames() {
        System.out.println(MSG_INPUT_CANDIDATE_NAMES);
        return scanner.nextLine().split(NAME_REGEX);
    }

    public static Integer inputMaxLadderHeight() {
        System.out.println(MSG_INPUT_MAX_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] inputExecutionResult() {
        System.out.println(MSG_INPUT_EXECUTION_RESULTS);
        return scanner.nextLine().split(RESULT_REGEX);
    }

    public static String inputResultCandidateName() {
        System.out.println(MSG_INPUT_RESULT_CANDIDATE_NAME);
        return scanner.nextLine();
    }
}
