package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";

    public static List<User> inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] usersName = scanner.nextLine().split(COMMA_DELIMITER);
        System.out.println();

        return Arrays.stream(usersName)
                .map(User::create)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return height;
    }

    public static GameResult inputLadderGameResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        GameResult gameResult = GameResult.create(Arrays.asList(scanner.nextLine().split(COMMA_DELIMITER)));
        System.out.println();
        return gameResult;
    }

    public static String inputNameForGetResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String userName = scanner.nextLine();
        System.out.println();
        return userName;
    }
}
