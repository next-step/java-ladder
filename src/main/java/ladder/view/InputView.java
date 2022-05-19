package ladder.view;

import ladder.util.SplitStringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String PARTICIPANT_GUIDE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String EXECUTE_RESULT_GUIDE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_GUIDE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String VIEW_COMMAND_GUIDE = "\n결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static List<String> scanParticipantNames() {
        System.out.println(PARTICIPANT_GUIDE);
        return SplitStringUtils.split(scanner.nextLine(), COMMA_DELIMITER);
    }

    public static List<String> scanScores() {
        System.out.println(EXECUTE_RESULT_GUIDE);
        return SplitStringUtils.split(scanner.nextLine(), COMMA_DELIMITER);
    }

    public static int scanLadderHeight() {
        System.out.println(LADDER_HEIGHT_GUIDE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String scanResultViewCommand() {
        System.out.println(VIEW_COMMAND_GUIDE);
        return scanner.nextLine();
    }
}
