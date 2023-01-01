package nextstep.ladder.view;

import java.util.Scanner;

public class inputView {

    private static final String JOIN_MEMBER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_COUNT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputJoinMember(){
        System.out.println(JOIN_MEMBER);
        return sc.nextLine();
    }

    public static int inputLadderCount(){
        System.out.println(LADDER_COUNT);
        return Integer.parseInt(sc.nextLine());
    }

}
