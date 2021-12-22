package nextstep.ladder.view;

import java.util.Scanner;

public final class InputView {
    private static final String PARTICIPANT_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String readParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_INPUT_MESSAGE);
        return readString();
    }

    private static String readString() {
        return SCANNER.nextLine();
    }
}
