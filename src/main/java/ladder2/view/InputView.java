package ladder2.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder2.domain.Player;
import ladder2.domain.Players;
import ladder2.domain.Prize;
import ladder2.domain.Prizes;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PLAYER_NAME_TO_CHECK_MESSAGE = "결과를 보고 싶은 사람은?";
    private final Scanner scanner = new Scanner(System.in);

    public Players inputPlayers() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String line = scanner.nextLine();

        String[] playerNames = line.split(DELIMITER);
        List<Player> players = IntStream.range(0, playerNames.length)
            .mapToObj(i -> new Player(i, playerNames[i].trim()))
            .collect(Collectors.toList());
        return new Players(players);
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public Prizes inputPrizes() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        String line = scanner.nextLine();

        String[] prizeNames = line.split(DELIMITER);
        List<Prize> prizes = IntStream.range(0, prizeNames.length)
            .mapToObj(i -> new Prize(i, prizeNames[i]))
            .collect(Collectors.toList());
        return new Prizes(prizes);
    }

    public String inputPlayerNameToCheck() {
        System.out.println(INPUT_PLAYER_NAME_TO_CHECK_MESSAGE);
        return scanner.nextLine();
    }
}
