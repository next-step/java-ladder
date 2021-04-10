package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MEMBER_MESSAGE = "참여할 사람 이름을 입력하세요.";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputLadderGameMember(){
        System.out.println(INPUT_MEMBER_MESSAGE);
        return scanner.next();
    }

    public static int inputLadderHeight(){
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }
}
