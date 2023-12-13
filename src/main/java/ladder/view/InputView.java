package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String NOTICE_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NOTICE_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String NAME_SPLITTER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputParticipants() {
        System.out.println(NOTICE_INPUT_PARTICIPANTS);
        return SCANNER.nextLine().split(NAME_SPLITTER);
    }

    public static int inputLadderHeight() {
        System.out.println(NOTICE_LADDER_HEIGHT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
