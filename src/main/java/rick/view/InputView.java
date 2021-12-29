package rick.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import rick.domain.Players;
import rick.domain.Rewards;

public class InputView {

    private static final Scanner STANDARD_INPUT_SCANNER = new Scanner(System.in);
    private static final String MESSAGE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_NAME_FOR_RESULT = "결과를 보고 싶은 사람은?";
    private static final String MESSAGE_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_LADDER_LINE_COUNT = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static String getPlayerNameForResult() {
        System.out.println(MESSAGE_NAME_FOR_RESULT);

        return STANDARD_INPUT_SCANNER.nextLine();
    }

    public static Players getPlayerNames() {
        System.out.println(MESSAGE_NAMES);
        final String input = STANDARD_INPUT_SCANNER.nextLine();

        return Arrays.stream(input.split(DELIMITER))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }

    public static Rewards getRewards() {
        System.out.println(MESSAGE_REWARDS);
        final String input = STANDARD_INPUT_SCANNER.nextLine();

        return Arrays.stream(input.split(DELIMITER))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public static int getLadderLineCount() {
        System.out.println(MESSAGE_LADDER_LINE_COUNT);

        final String input = STANDARD_INPUT_SCANNER.nextLine();

        return Integer.parseInt(input);
    }
}
