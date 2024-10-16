package laddergame.ui;

import laddergame.domain.Line;
import laddergame.domain.Players;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행결과";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String SPACING_BETWEEN_PLAYERS = "    ";

    public void showLadderGameResult(Players players, List<Line> ladder) {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
        showPlayers(players);
        showLadder(ladder);
    }

    private void showPlayers(Players players) {
        String playerNames = players.getPlayers().stream()
                .map(player -> player.getName() + SPACING_BETWEEN_PLAYERS)
                .collect(joining());
        System.out.println(playerNames);
    }

    private void showLadder(List<Line> ladder) {
        ladder.stream()
                .flatMap(line -> line.getPoints().stream()
                        .map(this::drawHorizontalLine)
                        .collect(joining())
                        .concat(LADDER_VERTICAL_LINE)
                        .lines())
                .forEach(System.out::println);
    }

    private String drawHorizontalLine(boolean lineStatus) {
        return LADDER_VERTICAL_LINE + (lineStatus ? LADDER_HORIZONTAL_LINE : "     ");
    }
}
