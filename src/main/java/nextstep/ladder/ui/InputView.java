package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USER_NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String SPLIT_DELIMITER = ",";

    private InputView() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static Users readUsers() {
        System.out.println(USER_NAMES_QUESTION);
        return getUsers();
    }

    public static PositiveNumber readLadderHeight() {
        System.out.println(LADDER_HEIGHT_QUESTION);
        return new PositiveNumber(readInt());
    }

    private static Users getUsers() {
        Set<User> users = Arrays.stream(readText().split(SPLIT_DELIMITER))
                .map(String::trim)
                .map(User::new)
                .collect(Collectors.toSet());
        return new Users(users);
    }

    private static String readText() {
        return SCANNER.nextLine();
    }

    private static int readInt() {
        return SCANNER.nextInt();
    }
}
