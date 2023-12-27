package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String NOTICE_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NOTICE_INPUT_RESULT_DATA = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NOTICE_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String NOTICE_PARTICIPANT_RESULT = "\n결과를 보고 싶은 사람은?";
    public static final String SPLITTER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputParticipants() {
        System.out.println(NOTICE_INPUT_PARTICIPANTS);
        return SCANNER.nextLine().split(SPLITTER);
    }

    public static String[] inputResultData() {
        System.out.println(NOTICE_INPUT_RESULT_DATA);
        return SCANNER.nextLine().split(SPLITTER);
    }

    public static int inputLadderHeight() {
        System.out.println(NOTICE_LADDER_HEIGHT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputParticipantResult() {
        System.out.println(NOTICE_PARTICIPANT_RESULT);
        return SCANNER.nextLine();
    }
}
