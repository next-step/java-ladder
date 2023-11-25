package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    public static final String LADDER_HEIGHT_INPUT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private final static Scanner SCANNER = new Scanner(System.in);
    public static final String PARTICIPANTS_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_RESULT_INPUT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private InputView() {
    }

    public static String inputParticipants() {
        System.out.println(PARTICIPANTS_INPUT_MSG);
        return SCANNER.next();
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MSG);
        return SCANNER.nextInt();
    }

    public static String inputLadderResult() {
        System.out.println(LADDER_RESULT_INPUT_MSG);
        return SCANNER.next();
    }
}
