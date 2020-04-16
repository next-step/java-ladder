package ladder.view;

import java.util.Scanner;

public class LadderInput {
    private static final String USER_ADD_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_ADD_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_ADD_MESSAGE ="실행 결과를 입력하세요 (결과는 쉼표(,)로 구분하세요)";
    private static final String USER_LADDER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner sc = new Scanner(System.in);

    public static String userAdd(){
        System.out.println(USER_ADD_MESSAGE);
        return sc.nextLine();
    }

    public static int ladderHeight(){
        System.out.println(LADDER_HEIGHT_ADD_MESSAGE);
        return Integer.parseInt(sc.nextLine());
    }

    public static String resultAdd(){
        System.out.println(RESULT_ADD_MESSAGE);
        return sc.nextLine();
    }

    public static String checkUserResult(){
        System.out.println(USER_LADDER_RESULT_MESSAGE);
        return sc.nextLine();
    }
}
