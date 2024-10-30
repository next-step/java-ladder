package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PARTICIPANTS_NAME_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String inputParticipantsName() {
        System.out.println(PARTICIPANTS_NAME_QUESTION);
        return SCANNER.nextLine();
    }
}
