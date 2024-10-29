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

    public static int inputLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getInputInteger();
    }

    private static List<User> parseUsers(String userNames) {
        return Arrays.stream(userNames.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
