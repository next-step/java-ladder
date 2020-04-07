package ladder.view;

import java.util.Scanner;

public class LadderInput {
    private static final String USER_ADD_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDAR_HEIGHT_ADD_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public String userAdd(){
        System.out.println(USER_ADD_MESSAGE);
        return sc.nextLine();
    }

    public int ladderHeight(){
        System.out.println(LADDAR_HEIGHT_ADD_MESSAGE);
        return Integer.parseInt(sc.nextLine());
    }
}
