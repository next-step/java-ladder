package nextstep.step2.view;

import nextstep.step2.VO.Position;
import nextstep.step2.VO.User;
import nextstep.step2.VO.Users;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USER_EXCEPTION_COMMENT = "최소 2인 이상 입력해주셔야 합니다.";
    private static final String HEIGHT_EXCEPTION_COMMENT = "최소 1이상의 사다리 높이를 입력해주세요.";
    private static final String PLEASE_INPUT_USERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLEASE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";


    public static Users inputUsers() {
        System.out.println(PLEASE_INPUT_USERS_NAME);
        String[] names = getStringArray();
        List<User> users = getUserList(names);
        return new Users(users);
    }

    public static int inputHeight() {
        System.out.println(PLEASE_INPUT_LADDER_HEIGHT);
        return validateHeight(getIntValue());
    }

    public static List<User> getUserList(String[] names) {
        validateUserList(names);
        return IntStream.range(0, names.length)
                .mapToObj(index -> new User(names[index], new Position(index)))
                .collect(Collectors.toList());

    }

    private static int validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION_COMMENT);
        }
        return height;
    }

    private static void validateUserList(String[] names) {
        if (names.length <= 1) {
            throw new IllegalArgumentException(USER_EXCEPTION_COMMENT);
        }
    }

    private static String[] getStringArray() {
        String input = getStringValue();
        return input.split(",");
    }

    private static String getStringValue() {
        return SCANNER.nextLine();
    }

    private static int getIntValue() {
        return Integer.parseInt(getStringValue());
    }

}
