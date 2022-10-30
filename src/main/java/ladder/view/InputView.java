package ladder.view;

import java.util.Scanner;

import static ladder.utils.StringUtils.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);




    public static String inputCandidateNames() {
        System.out.println(MSG_INPUT_CANDIDATE_NAMES);
        return scanner.nextLine();
    }

    public static Integer inputMaxLadderHeight() {
        System.out.println(MSG_INPUT_MAX_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputExecutionResult() {
        System.out.println(MSG_INPUT_EXECUTION_RESULTS);
        return scanner.nextLine();
    }

    public static String inputResultCandidateName() {
        System.out.println(MSG_INPUT_RESULT_CANDIDATE_NAME);
        return scanner.nextLine();
    }
}
