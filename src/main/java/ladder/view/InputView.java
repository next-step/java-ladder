package ladder.view;

import ladder.domain.User;
import ladder.domain.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USERS_DELIMITER = ",";

    public static Users inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] usersName = scanner.nextLine().split(USERS_DELIMITER);

        return Users.create(Arrays.stream(usersName)
                .map(User::create)
                .collect(Collectors.toList()));
    }
}
