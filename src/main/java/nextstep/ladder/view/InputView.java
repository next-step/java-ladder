package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    public static final String PARTICIPANTS_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private InputView() {
    }

    public static String inputParticipantNames() {
        System.out.println(PARTICIPANTS_INPUT_MSG);
        return SCANNER.next();
    }

}
