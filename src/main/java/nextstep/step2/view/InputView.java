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
    private static final String PLEASE_INPUT_USERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLEASE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";


    private static Users inputUsers() {
        System.out.println(PLEASE_INPUT_USERS_NAME);
        String[] names = getStringArray();
        List<User> users = getUserList(names);
        return new Users(users);
    }

    public static List<User> getUserList(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(index -> new User(names[index], new Position(index)))
                .collect(Collectors.toList());

    }

    private static String[] getStringArray() {
        String input = getStringValue();
        return input.split(",");
    }

    private static String getStringValue() {
        return SCANNER.nextLine();
    }

}
