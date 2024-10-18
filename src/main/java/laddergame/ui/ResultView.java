package laddergame.ui;

import laddergame.domain.Ladder;
import laddergame.domain.LadderPositionResult;
import laddergame.domain.Players;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행결과";
    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String SPACING_BETWEEN_PLAYERS = "    ";

    public void showLadder(Players players, Ladder ladder, LadderPositionResult positionResult) {
        System.out.println();
        System.out.println(RESULT_LADDER_MESSAGE);
        showPlayers(players);
        showLadder(ladder);
        showGameResult(positionResult);
    }

    private void showPlayers(Players players) {
        String playerNames = players.getPlayers().stream()
                .map(player -> player.getName() + SPACING_BETWEEN_PLAYERS)
                .collect(joining());
        System.out.println(playerNames);
    }

    private void showLadder(Ladder ladder) {
        ladder.getLines().stream()
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

    private void showGameResult(LadderPositionResult positionResult) {
        List<String> gameResultsByInputOrder = positionResult.getGameResultByInputOrder();
        String gameResults = getString(gameResultsByInputOrder);
        System.out.println(gameResults);
    }

    private String getString(List<String> gameResultsByInputOrder) {
        return gameResultsByInputOrder.stream()
                .map(result -> result + SPACING_BETWEEN_PLAYERS)
                .collect(joining());
    }
}