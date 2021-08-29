package ladder.presentation.input;

import java.util.Scanner;

public class AskingUserInputView {

    private static final String ASKING_USER_COMMENT = "실행결과를 보고 싶은 사람은?";

    public String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ASKING_USER_COMMENT);
        return sc.nextLine();
    }
}
