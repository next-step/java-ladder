package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Line;

import java.util.List;

public class ResultView {

    public static void printResult(final LadderGame ladderGame) {
        printPlayers(ladderGame.getPlayerNames());
        printLadder(ladderGame.getLadder());
    }

    private static void printPlayers(final List<String> playerNames) {
        System.out.println(String.join(" ", playerNames));
    }

    private static void printLadder(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        final int totalLineCount = lines.size();
        final int row = totalLineCount / ladder.height();

        for (int i = 0; i < totalLineCount; i++) {
            final Line line = lines.get(i);

            if (isNextRow(row, i)) {
                System.out.println();
            }

            System.out.print("|");

            if (line.isRightLink()) {
                System.out.print("-----");
            }

            if (!line.isRightLink() && !isLastRow(totalLineCount, i)) {
                System.out.print("     ");
            }
        }
    }

    private static boolean isLastRow(final int totalLineCount, final int i) {
        return i == totalLineCount - 1;
    }

    private static boolean isNextRow(final int row, final int i) {
        return i / row > 0 && i % row == 0;
    }
}
