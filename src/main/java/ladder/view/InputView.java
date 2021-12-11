package ladder.view;

import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    public static Users inputUserName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] users = scanner.next().split(COMMA);
        return new Users(Arrays.stream(users)
                .map(user -> new User(user))
                .collect(Collectors.toList()));
    }
}
