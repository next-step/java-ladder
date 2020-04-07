package ladder;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<User> inputJoinUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String values = scanner.nextLine();

        List<User> users = Arrays.asList(values.split(",")).stream()
                .map(User::new)
                .collect(Collectors.toList());

        return users;
    }

    public static int inputLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
