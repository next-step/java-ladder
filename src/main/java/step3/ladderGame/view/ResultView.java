package step3.ladderGame.view;

import step3.ladderGame.domain.award.Awards;
import step3.ladderGame.domain.ladder.Ladder;
import step3.ladderGame.domain.ladder.Line;
import step3.ladderGame.domain.ladder.Point;
import step3.ladderGame.domain.palyer.Player;
import step3.ladderGame.domain.palyer.Players;

public final class ResultView {

    private static final int NAME_SPACE = 6;
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public static void printPlayers(Players players) {
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

    public static void printAwards(Awards awards) {
        StringBuilder builder = new StringBuilder();
        awards.getAwards().forEach(
                award -> {
                    String blank = printBlank(award.getName());
                    builder.append(blank).append(award.getName());
                }
        );
        System.out.println(builder);
    }

    private static String printBlank(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int emptyLength = NAME_SPACE - name.length();

        while (emptyLength > 0) {
            stringBuilder.append(BLANK);
            emptyLength--;
        }

        return stringBuilder.toString();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder builder = new StringBuilder();

        for (Point point : line.getPoints()) {
            builder.append(printBetweenLine(point));
            builder.append(VERTICAL_LINE);
        }

        System.out.println(builder);
    }

    private static String printBetweenLine(Point point) {
        if (point.hasLeftDirectionLine()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

    public static void printWinningAward(int playerIndex, Awards awards) {
        System.out.println("\n실행결과");
        System.out.println(awards.findResult(playerIndex));
    }

    public static void printWinningAwardAll(Players players, Awards awards, Ladder ladder) {
        System.out.println("\n실행결과");

        for (Player player : players.getPlayers()) {
            System.out.print(player.getName() + " : ");
            System.out.println(awards.findResult(ladder.move(player.getIndex())));
        }
    }

}
