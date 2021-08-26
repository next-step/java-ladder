package ladder.presentation.input;

import java.util.Scanner;

public class UserResultInputView {

    private static final String INPUT_COMMENT = "결과를 보고 싶은 사람은?";

    public String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_COMMENT);
        String user = sc.nextLine();
        System.out.println();
        return user;
    }
}
