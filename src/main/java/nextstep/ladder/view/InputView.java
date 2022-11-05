package nextstep.ladder.view;

import nextstep.ladder.User;
import nextstep.ladder.Users;
import nextstep.ladder.UsersFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Users getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        List<String> names = Arrays.stream(SCANNER.nextLine().split(COMMA))
                .collect(Collectors.toList());
        return UsersFactory.createUsers(names);
    }

    public static List<String> getExecuteResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)");
        return Arrays.asList(SCANNER.nextLine().split(COMMA));
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static User getUserNameForResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name = SCANNER.next();
        return new User(name);
    }
}
