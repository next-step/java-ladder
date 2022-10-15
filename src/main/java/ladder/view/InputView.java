package ladder.view;

import ladder.domain.ladderresult.LadderResult;
import ladder.domain.ladderresult.LadderResults;
import ladder.domain.player.Player;
import ladder.domain.player.PlayerName;
import ladder.domain.player.PlayerNames;
import ladder.domain.player.Players;
import ladder.domain.position.Position;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ELEMENTS_DELIMITER = ",";
    private static final String LADDER_RESULTS_QUESTION = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String TARGET_PLAYERS_QUESTION = "\n결과를 보고 싶은 사람은? (all: 모두)";
    private static final String ALL = "all";

    private static final Scanner scanner = new Scanner(System.in);

    public static InputDto scan() {
        System.out.println(NAMES_QUESTION);
        Players players = scanPlayers();

        System.out.println(LADDER_RESULTS_QUESTION);
        LadderResults ladderResults = scanLadderResults();
        validateLadderResultsCount(players, ladderResults);

        System.out.println(HEIGHT_QUESTION);
        Integer height = scanHeight();

        return new InputDto(players, height, ladderResults);
    }

    public static PlayerNames scanTargetPlayers(Players players) {
        System.out.println(TARGET_PLAYERS_QUESTION);
        String[] names = scanner.nextLine().split(ELEMENTS_DELIMITER);
        if (names.length == 1 && ALL.equals(names[0])) {
            return players.toPlayerNames();
        }

        return new PlayerNames(Arrays.stream(names)
                .map(PlayerName::new)
                .collect(toList()));
    }

    public static void closeScan() {
        scanner.close();
    }

    private static Players scanPlayers() {
        String[] names = scanner.nextLine().split(ELEMENTS_DELIMITER);

        return new Players(IntStream.range(0, names.length)
                .mapToObj(i -> new Player(new PlayerName(names[i]), new Position(i)))
                .collect(toList()));
    }

    private static Integer scanHeight() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static LadderResults scanLadderResults() {
        return new LadderResults(Arrays.stream(scanner.nextLine()
                        .split(ELEMENTS_DELIMITER))
                .map(LadderResult::new)
                .collect(toList()));
    }

    private static void validateLadderResultsCount(Players players, LadderResults ladderResults) {
        if (players.count() != ladderResults.count()) {
            throw new IllegalArgumentException("플레이어 수와 사다리 결과 수는 같아야 합니다.");
        }
    }
}
