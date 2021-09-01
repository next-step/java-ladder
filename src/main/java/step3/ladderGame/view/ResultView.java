package step3.ladderGame.view;

import step3.ladderGame.domain.ladder.Ladder;
import step3.ladderGame.domain.ladder.Line;
import step3.ladderGame.domain.ladder.Point;
import step3.ladderGame.domain.palyer.Player;
import step3.ladderGame.domain.palyer.Players;
import step3.ladderGame.domain.result.Results;

import java.util.List;

public final class ResultView {

    private static final int NAME_SPACE = 6;
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printPlayers(List<String> players) {
        StringBuilder builder = new StringBuilder();
        System.out.println("\n사다리 결과\n");

        players.forEach(
                player -> {
                    String blank = printBlank(player);
                    builder.append(blank).append(player);
                }
        );

        System.out.println(builder);
    }

    public void printResults(List<String> prizes) {
        StringBuilder builder = new StringBuilder();

        prizes.forEach(
                prize -> {
                    String blank = printBlank(prize);
                    builder.append(blank).append(prize);
                }
        );

        System.out.println(builder);
    }

    private String printBlank(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int emptyLength = NAME_SPACE - name.length();

        while (emptyLength > 0) {
            stringBuilder.append(BLANK);
            emptyLength--;
        }

        return stringBuilder.toString();
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();

        for (Point point : line.getPoints()) {
            builder.append(printBetweenLine(point));
            builder.append(VERTICAL_LINE);
        }

        System.out.println(builder);
    }

    private String printBetweenLine(Point point) {
        if (point.hasLeftDirectionLine()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

    public void printWinningResult(int playerIndex, Results results) {
        System.out.println("\n실행결과");
        System.out.println(results.findResult(playerIndex));
    }

    public void printWinningResultAll(Players players, Results results, Ladder ladder) {
        System.out.println("\n실행결과");

        for (Player player : players.getPlayers()) {
            System.out.print(player.getName() + " : ");
            System.out.println(results.findResult(ladder.move(player.getIndex())));
        }
    }

}
