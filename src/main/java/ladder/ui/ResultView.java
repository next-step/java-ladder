package ladder.ui;

import ladder.domain.ladder.Award;
import ladder.domain.ladder.Awards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResult;
import ladder.domain.line.Line;
import ladder.domain.player.Player;
import ladder.utils.StringUtil;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LADDER_GRAPH = "\n사다리 결과\n";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String VERTICAL_DELIMITER_PREFIX = "  |";
    private static final String LINE_DASH = "-----";
    private static final String LINE_EMPTY = "     ";
    private static final String LADDER_RESULT = "\n실행결과";

    public static void printLadder(Ladder ladder) {
        printPlayers(ladder);

        ladder.getLines().stream()
                .map(ResultView::lineToDash)
                .forEach(System.out::println);
    }

    private static String lineToDash(Line line) {
        return line.getPoints().stream()
                .map(point -> point.value() ? LINE_DASH : LINE_EMPTY)
                .collect(Collectors.joining(VERTICAL_DELIMITER, VERTICAL_DELIMITER_PREFIX, VERTICAL_DELIMITER));
    }

    private static void printPlayers(Ladder ladder) {
        System.out.println(LADDER_GRAPH);

        String namesOfPlayers = ladder.getPlayers().stream()
                .map(Player::name)
                .map(name -> StringUtil.rightPad(name, 6))
                .collect(Collectors.joining());
        System.out.println(namesOfPlayers);
    }

    public static void printAwards(Awards awards) {
        String namesOfAwards = awards.getAwards().stream()
                .map(Award::name)
                .map(name -> StringUtil.rightPad(name, 6))
                .collect(Collectors.joining());
        System.out.println(namesOfAwards);
    }

    public static void printWantedPlayer(LadderResult ladderResult, String wantedPlayer) {
        System.out.println(LADDER_RESULT);
        System.out.println(ladderResult.resultOfPlayer(wantedPlayer));
    }

    public static void printAllPlayer(Map<String, String> results) {
        System.out.println(LADDER_RESULT);
        results.entrySet()
                .stream()
                .map(ResultView::resultAllPlayer)
                .forEach(System.out::println);
    }

    private static String resultAllPlayer(Map.Entry<String, String> entry) {
        return String.format("%s : %s", entry.getKey(), entry.getValue());
    }
}
