package nextstep.laddar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.laddar.User;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<User> getUserName() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map((User::new))
                .collect(Collectors.toList());
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
