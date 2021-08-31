package ladder.view;

import ladder.model.Player;
import ladder.model.PlayingResult;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String INPUT_NAME_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String INPUT_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MATCH_MSG = "결과를 보고 싶은 사람은?";

    private static Scanner scanner = new Scanner(System.in);

    public static List<Player> readPlayerName() {
        System.out.println(INPUT_NAME_MSG);
        String names = scanner.next();

        try {
            return Stream.of(names.split(DELIMITER))
                    .map(String::trim)
                    .map(Player::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayerName();
        }
    }

    public static int readHeight() {
        System.out.println(INPUT_HEIGHT_MSG);
        return scanner.nextInt();
    }

    public static List<PlayingResult> readResult() {
        System.out.println(INPUT_RESULT_MSG);
        String result = scanner.next();

        try {
            return Stream.of(result.split(DELIMITER))
                    .map(String::trim)
                    .map(PlayingResult::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readResult();
        }
    }

    public static String readMatchPlayer() {
        System.out.println(INPUT_MATCH_MSG);
        return scanner.next();
    }

}
