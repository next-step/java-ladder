package nextstep.ladder.view;

import nextstep.ladder.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<User> inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNames = getInputString();
        return parseUsers(userNames);
    }

    private static List<User> parseUsers(String userNames) {
        return Arrays.stream(userNames.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
