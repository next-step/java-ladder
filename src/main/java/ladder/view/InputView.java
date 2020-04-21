package ladder.view;

import ladder.domain.Users;
import ladder.domain.exception.InvalidNamesInputException;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String USER_NAMES_DELIMITER = ",";
    private static final String GET_USER_NAMES_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static Users getUsers() {
        System.out.println(GET_USER_NAMES_NOTICE);

        String userNames = scanner.nextLine();
        if (!isValidNamesInput(userNames)) {
            throw new InvalidNamesInputException();
        }

        return Users.getInstanceByUserNames(userNames.split(USER_NAMES_DELIMITER));
    }

    private static boolean isValidNamesInput(String userNames) {
        return !Objects.isNull(userNames) && !userNames.isEmpty();
    }
}
