package nextstep.ladder.view;

import nextstep.ladder.domain.Users;

import java.util.Scanner;

public class UserInputView {

    private static final String USER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static Users enter() {
        System.out.println(USER_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String userNameString = scanner.next();
        Users users = new Users(userNameString);
        return users;
    }
}
