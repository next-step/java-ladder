package ladder.view;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printStream = System.out;

    private static final String ASK_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_GOALS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String ASK_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_PERSONAL_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    public static String askParticipantNames() {

        printStream.println(ASK_PARTICIPANT_NAMES_MESSAGE);
        return scanner.next();
    }

    public static String askGoals() {

        printStream.println(ASK_GOALS_MESSAGE);
        return scanner.next();
    }

    public static int askHeight() {

        printStream.println(ASK_MAX_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }

    public static String askPersonalResult() {

        printStream.println(ASK_PERSONAL_RESULT_MESSAGE);
        return scanner.next();
    }
}
