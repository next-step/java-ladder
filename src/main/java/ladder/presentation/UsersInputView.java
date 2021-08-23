package ladder.presentation;

import java.util.Scanner;

public class UsersInputView {

    private static final String USERS_INPUT_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String input(){
        Scanner sc = new Scanner(System.in);
        System.out.println(USERS_INPUT_COMMENT);
        return sc.nextLine();
    }
}
