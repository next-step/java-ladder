package nextstep.ladder.domain.view;

import nextstep.ladder.domain.exception.InvalidInputException;
import nextstep.util.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String ENTRY_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> playerNames() {
        ResultView.println(ENTRY_MESSAGE);

        String inputString = SCANNER.nextLine().replaceAll(" ", "");

        verifyPlayersNames(inputString);

        return stream(inputString.split(DELIMITER))
                .collect(Collectors.toList());
    }

    private static void verifyPlayersNames(final String inputString) {
        if (!inputString.contains(DELIMITER)) {
            throw new InvalidInputException("입력이 잘못됐습니다.");
        }

        if (StringUtils.isEmpty(inputString)) {
            throw new InvalidInputException("입력이 없습니다.");
        }
    }

    public static int ladderHeight() {
        ResultView.println(MAX_LADDER_HEIGHT_MESSAGE);
        return SCANNER.nextInt();
    }
}
