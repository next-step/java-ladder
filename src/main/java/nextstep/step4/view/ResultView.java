package nextstep.step4.view;

import nextstep.step4.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String EXISTED_LINE = "|-----";
    private static final String NOT_EXISTED_LINE = "|     ";
    private static final String BLANK = "    ";
    private static final String COLON = " : ";
    private static final String NEWLINE = "\n";

    public void printLadderStatus(Players players, Ladder ladder, LadderResult ladderResult) {
        printPlayers(players);
        printLadder(ladder);
        printLadderResult(ladderResult);
    }

    private void printPlayers(Players players) {
        StringBuilder playersBuilder = new StringBuilder();
        System.out.println("사다리 결과");
        players.getPlayers()
                .forEach(playerName -> {
                    playersBuilder.append(playerName.getPlayerName()).append(BLANK);
                });
        System.out.println(playersBuilder);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadder()
                .stream()
                .map(Line::getPoints)
                .forEach(this::printLines);
    }

    private void printLines(List<Point> points) {
        StringBuilder lineBuilder = new StringBuilder();
        points.forEach(point -> {
            if (point.isRight()) {
                lineBuilder.append(EXISTED_LINE);
                return;
            }
            lineBuilder.append(NOT_EXISTED_LINE);
        });
        System.out.println(lineBuilder);
    }

    private void printLadderResult(LadderResult ladderResult) {
        StringBuilder ladderResultBuilder = new StringBuilder();
        ladderResult.getLadderResult()
                .forEach(result -> {
                    ladderResultBuilder.append(result).append(BLANK);
                });
        System.out.println(ladderResultBuilder);
    }

    public void printLadderGameResult(Map<PlayerName, String> ladderGameResult) {
        StringBuilder resultBuilder = new StringBuilder();

        ladderGameResult.forEach((playerName, result) ->
                resultBuilder
                        .append(playerName.getPlayerName())
                        .append(COLON)
                        .append(result)
                        .append(NEWLINE)
        );

        System.out.println(resultBuilder);
    }
}
