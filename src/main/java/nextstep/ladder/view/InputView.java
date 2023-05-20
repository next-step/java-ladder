package nextstep.ladder.view;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String SPLIT_REGEX = ",";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Users inputUserName() {
        String input = scanner.nextLine();
        String[] names = input.split(SPLIT_REGEX);
        Users users = new Users();
        Arrays.stream(names).forEach((name) -> users.add(new User(name)));
        return users;
    }

}
