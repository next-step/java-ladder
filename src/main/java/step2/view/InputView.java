package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MEMBER_MESSAGE = "참여할 사람 이름을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputLadderGameMember(){
        System.out.println(INPUT_MEMBER_MESSAGE);
        return scanner.next();
    }
}
