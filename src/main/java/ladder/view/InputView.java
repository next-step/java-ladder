package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String PRINT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRINT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static List<String> printPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_PLAYER_NAMES);

        String names = scanner.nextLine();

        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int printHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_LADDER_HEIGHT);

        return scanner.nextInt();
    }
}
