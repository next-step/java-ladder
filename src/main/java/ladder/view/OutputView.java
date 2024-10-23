package ladder.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import ladder.InputResult;
import ladder.LadderOld;
import ladder.LadderResult;
import ladder.PlayerOld;
import ladder.PlayersOld;

public class OutputView {

    private static final String PLAYER_DELIMITER = "    ";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_BLANK = "     ";

    public static void outputLadderGame(PlayersOld playersOld, LadderOld ladderOld, InputResult inputResult) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        playerView(playersOld);
        ladderView(ladderOld);
        resultView(inputResult.getLadderResults());
    }

    public static void outputOneResult(String resultInput, LadderResult ladderResult) {
        System.out.println("실행결과");
        System.out.println(ladderResult.getOne(resultInput));
    }

    public static void outputAllResult(LadderResult ladderResult) {
        viewAll(ladderResult.getResults());
    }

    private static void viewAll(Map<String, String> results) {
        results.entrySet()
            .forEach(value -> System.out.println(value.getKey() + " : " + value.getValue()));
    }

    private static void playerView(PlayersOld playersOld) {
        String playerNames = playersOld.getPlayers().stream()
            .map(PlayerOld::getName)
            .collect(Collectors.joining(PLAYER_DELIMITER));

        System.out.println(playerNames);
    }

    private static void ladderView(LadderOld ladderOld) {
        ladderOld.getLines().stream()
            .flatMap(line -> line.getPoints().stream()
                .map(OutputView::drawHorizon)
                .collect(Collectors.joining())
                .concat(LADDER_VERTICAL)
                .lines())
            .map(it -> LADDER_BLANK + it)
            .forEach(System.out::println);
    }

    private static void resultView(String[] results) {
        System.out.print(PLAYER_DELIMITER);
        Arrays.stream(results)
            .map(it -> it + PLAYER_DELIMITER)
            .forEach(System.out::print);
    }

    private static String drawHorizon(boolean checkDraw) {
        return LADDER_VERTICAL + (checkDraw ? LADDER_HORIZON : LADDER_BLANK);
    }
}
