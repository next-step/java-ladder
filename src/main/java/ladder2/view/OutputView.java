package ladder2.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ladder.InputResult;
import ladder2.Ladder;
import ladder2.LadderResult;
import ladder2.Player;
import ladder2.Players;
import ladder2.Position;

public class OutputView {

    private static final String PLAYER_DELIMITER = "    ";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_BLANK = "     ";

    public static void outputLadderGame(Players players, Ladder ladder, InputResult inputResult) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        playerView(players);
        ladderView(ladder);
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

    private static void playerView(Players players) {
        String playerNames = players.getPlayers().stream()
            .map(Player::getName)
            .collect(joining(PLAYER_DELIMITER));

        System.out.println(playerNames);
    }

    private static void ladderView(Ladder ladder) {
        String ladderView = ladder.getLines().stream()
            .map(line -> drawLines(line.getPositions()) + "\n")
            .map(it -> LADDER_BLANK + it)
            .collect(joining());
        System.out.println(ladderView);
    }

    private static String drawLines(List<Position> positions) {
        return positions.stream()
            .map(OutputView::drawLine)
            .collect(joining());
    }

    private static String drawLine(Position position) {
        return LADDER_VERTICAL + (position.lineOrBlank() ? LADDER_HORIZON : LADDER_BLANK);
    }

    private static void resultView(String[] results) {
        System.out.print(PLAYER_DELIMITER);
        Arrays.stream(results)
            .map(it -> it + PLAYER_DELIMITER)
            .forEach(System.out::print);
    }
}
