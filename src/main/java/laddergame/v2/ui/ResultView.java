package laddergame.v2.ui;

import laddergame.v2.domain.Ladder;
import laddergame.v2.domain.LadderResult;
import laddergame.v2.domain.Players;
import laddergame.v2.domain.Position;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행결과";
    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String SPACING_BETWEEN_PLAYERS = "    ";
    private static final String GAME_RESULT_FORMAT = "%s : %s\n";

    public static void showLadder(Players players, Ladder ladder, LadderResult positionResult) {
        System.out.println();
        System.out.println(RESULT_LADDER_MESSAGE);
        showPlayers(players);
        showLadder(ladder);
        showGameResult(positionResult);
    }

   private static void showPlayers(Players players) {
        String playerNames = players.getPlayers().stream()
                .map(player -> player.getName() + SPACING_BETWEEN_PLAYERS)
                .collect(joining());
        System.out.println(playerNames);
    }

    private static void showLadder(Ladder ladder) {
        String ladderPattern = ladder.getLines().stream()
                .map(line -> drawLines(line.getPositions()) + "\n")
                .collect(joining());
        System.out.println(ladderPattern);
    }

    private static String drawLines(List<Position> positions) {
        return positions.stream()
                .map(ResultView::draw)
                .collect(joining());
    }

    private static String draw(Position position) {
        return LADDER_VERTICAL_LINE + (position.hasBridge() ? LADDER_HORIZONTAL_LINE : "     ");
    }

    private static void showGameResult(LadderResult ladderResult) {
        String results = getResult(ladderResult.getResults());
        System.out.println(results);
    }

    private static String getResult(List<String> gameResultsByInputOrder) {
        return gameResultsByInputOrder.stream()
                .map(result -> result + SPACING_BETWEEN_PLAYERS)
                .collect(joining());
    }
}
