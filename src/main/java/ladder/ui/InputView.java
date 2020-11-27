package ladder.ui;

import static ladder.utils.StringUtils.splitByDelimiter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Position;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.model.LadderGameInfo;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class InputView {

    private static final String INPUT_SHOULD_INTEGER = "자연수로 입력 해 주세요.";
    private static final String PLEASE_INPUT_USERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLEASE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static LadderGameInfo ladderGameInfo() {
        Users users = inputUsers();
        LadderHeight ladderHeight = getLadderHeight();
        return new LadderGameInfo(users, ladderHeight);
    }

    private static Users inputUsers() {
        System.out.println(PLEASE_INPUT_USERS_NAME);
        String[] names = getStringArray();
        List<User> users = IntStream.range(0, names.length)
            .mapToObj(index -> new User(names[index], new Position(index)))
            .collect(Collectors.toList());
        return new Users(users);
    }

    private static LadderHeight getLadderHeight() {
        System.out.println(PLEASE_INPUT_LADDER_HEIGHT);
        return new LadderHeight(getIntValue());
    }

    private static String[] getStringArray() {
        String input = getStringValue();
        return splitByDelimiter(input);
    }

    private static int getIntValue() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(INPUT_SHOULD_INTEGER, e);
        } finally {
            SCANNER.nextLine();
        }
    }

    private static String getStringValue() {
        return SCANNER.nextLine();
    }
}
