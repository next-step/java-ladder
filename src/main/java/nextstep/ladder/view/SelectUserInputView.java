package nextstep.ladder.view;

import java.util.Scanner;

public class SelectUserInputView {

    private static final String SELECT_USER_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    public static String enter() {
        System.out.println(SELECT_USER_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        return next;
    }
}
