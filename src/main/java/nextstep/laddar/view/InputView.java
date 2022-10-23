package nextstep.laddar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.laddar.User;
import nextstep.laddar.Users;
import nextstep.laddar.UsersFactory;

public class InputView {
    private static final String NAME_SEPARATOR = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Users getUserName() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        List<String> names = Arrays.stream(SCANNER.nextLine().split(NAME_SEPARATOR))
                .collect(Collectors.toList());
        return UsersFactory.createUsers(names);
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
