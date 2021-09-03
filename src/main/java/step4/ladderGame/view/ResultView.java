package step4.ladderGame.view;

import step4.ladderGame.domain.award.Awards;
import step4.ladderGame.domain.ladder.Ladder;
import step4.ladderGame.domain.ladder.LadderLine;
import step4.ladderGame.domain.ladder.Point;
import step4.ladderGame.domain.palyer.Players;

import java.util.stream.IntStream;

public final class ResultView {

    private static final int NAME_SPACE = 6;
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public static void printPlayers(final Players players) {
        StringBuilder builder = new StringBuilder();
        System.out.println("\n사다리 결과\n");
        players.getPlayers().forEach(
                player -> {
                    String blank = printBlank(player.getName());
                    builder.append(blank).append(player.getName());
                }
        );
        System.out.println(builder);
    }

    public static void printAwards(final Awards awards) {
        StringBuilder builder = new StringBuilder();
        awards.getAwards().forEach(
                award -> {
                    String blank = printBlank(award.getName());
                    builder.append(blank).append(award.getName());
                }
        );
        System.out.println(builder);
    }

    private static String printBlank(final String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int emptyLength = NAME_SPACE - name.length();

        IntStream.range(0, emptyLength)
                .forEach(index -> stringBuilder.append(BLANK));

        return stringBuilder.toString();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLadderLines().forEach(
                ResultView::printLine
        );
    }

    private static void printLine(final LadderLine line) {
        StringBuilder builder = new StringBuilder();
        line.getPoints().forEach(
                point -> {
                    builder.append(printBetweenLine(point));
                    builder.append(VERTICAL_LINE);
                }
        );
        System.out.println(builder);
    }

    private static String printBetweenLine(final Point point) {
        if (point.hasLeftDirectionLine()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

    public static void printWinningAward(final int playerIndex, final Awards awards) {
        System.out.println("\n실행결과");
        System.out.println(awards.findResult(playerIndex));
    }

    public static void printWinningAwardAll(final Players players, final Awards awards, final Ladder ladder) {
        System.out.println("\n실행결과");
        players.getPlayers().forEach(
                player -> {
                    System.out.print(player.getName() + " : ");
                    System.out.println(awards.findResult(ladder.move(player.getIndex())));
                }
        );
    }

}
