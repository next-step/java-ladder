package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {

    private static final String PRINTLN_PERSON_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String personName() {
        System.out.println(PRINTLN_PERSON_NAME);
        return scanner.next();
    }

}
