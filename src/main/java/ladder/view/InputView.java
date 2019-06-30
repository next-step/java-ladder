package ladder.view;

import java.io.PrintStream;
import java.util.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printStream = System.out;

    private static final String ASK_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static String askParticipantNames() {

        printStream.println(ASK_PARTICIPANT_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static int askLadderHeights() {

        printStream.println(ASK_LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }
}
