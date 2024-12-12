package nextstep.ladder.ui;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.LadderGameResult2;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.point.Point;
import nextstep.ladder.domain.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String PLAY_RESULT_MESSAGE = "\n실행 결과\n";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String LINE_DASH = "-----";
    private static final String LINE_EMPTY = "     ";
    private static final String LEFT_PADDING_EMPTY = "    ";
    private static final String ENTER = "\n";
    private static final String EMPTY = " ";
    private static final String ALIGN_RIGHT_FIVE_CHAR_FORMAT = "%5s";

    public static void printLadder(Ladder ladder, LadderResult ladderResult) {
        printResultMessage();
        printPlayersName(ladder.getPlayers());
        printLines(ladder.getLines(), ladder.getPlayers());
        printLadderResult(ladderResult.getLadderResult());
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printPlayersName(List<Player> players) {
        System.out.println(players.stream()
                                  .map(player -> String.format(ALIGN_RIGHT_FIVE_CHAR_FORMAT, player.getName()))
                                  .collect(Collectors.joining(EMPTY)));
    }

    public static void printLines(List<Line> lines, List<Player> players) {
        StringBuilder resultBuilder = new StringBuilder();
        int pointSize = players.size();

        lines.forEach(currentLine -> {
            resultBuilder.append(LEFT_PADDING_EMPTY);
            resultBuilder.append(generatePrintingLine(currentLine, pointSize - 1));
            resultBuilder.append(VERTICAL_DELIMITER);
            resultBuilder.append(ENTER);
        });

        System.out.print(resultBuilder);
    }

    public static void printLadderResult(List<String> ladderResult) {
        System.out.println(ladderResult.stream()
                                       .map(result -> String.format(ALIGN_RIGHT_FIVE_CHAR_FORMAT, result))
                                       .collect(Collectors.joining()));
    }

    public static String generatePrintingLine(Line line, int pointSize) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, pointSize)
                 .forEach(index -> {
                     Point currentPoint = line.getPoints().get(index);

                     stringBuilder.append(VERTICAL_DELIMITER);
                     stringBuilder.append(currentPoint.canMoveRight() ? LINE_DASH : LINE_EMPTY);
                 });

        return stringBuilder.toString();
    }

    public static void printGameResult2(LadderGameResult2 ladderGameResult2) {
        String playerName = InputView.getResultPlayer();

        System.out.print(PLAY_RESULT_MESSAGE);
        Optional.of(playerName)
                .filter("all"::equals)
                .ifPresentOrElse(
                    name -> System.out.println(ladderGameResult2.getResultAll()),
                    () -> System.out.println(ladderGameResult2.getResult(playerName))
                );
    }
}
