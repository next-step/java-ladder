package ladder.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public final String inputParticipantsByClient() {
        System.out.println(INPUT_PARTICIPANTS_MESSAGE);
        return SCANNER.nextLine();
    }

}
