package nextstep.ladder.ui;

import nextstep.ladder.domain.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLAYERS_NAME_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_TEXT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT_TEXT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER_COMMA = ",";

    public static List<Player> getPlayersName() {
        System.out.println(PLAYERS_NAME_TEXT);

        String inputPlayers = scanner.nextLine();

        return Arrays.stream(splitByDelimiter(inputPlayers))
                     .map(Player::new)
                     .collect(Collectors.toList());
    }

    public static int getLadderHeight() {
        System.out.println(LADDER_HEIGHT_TEXT);

        return scanner.nextInt();
    }

    public static List<String> getLadderResult() {
        System.out.println(LADDER_RESULT_TEXT);

        String inputLadderResult = scanner.nextLine();

        return Arrays.stream(splitByDelimiter(inputLadderResult))
                     .collect(Collectors.toList());
    }

    private static String[] splitByDelimiter(String text) {
        return text.split(DELIMITER_COMMA);
    }

}
