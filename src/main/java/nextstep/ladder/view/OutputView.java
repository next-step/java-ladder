package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Row;

import java.util.List;

public class OutputView {
    private static final String WALL = "|";
    private static final String SPACE = "     ";
    private static final String VERTEX = "-----";


    public static void printDrawResult(final Ladder ladder) {
        System.out.println("실행결과");
        printPlayers(ladder.getPlayers());
        printRows(ladder.getRows());
    }

    private static void printPlayers(final Players players) {
        players.asList()
                .forEach(OutputView::printPlayer);
        System.out.println();
    }

    private static void printPlayer(final Player player) {
        System.out.print(SPACE.substring(player.getName().length() - 1));
        System.out.print(player.getName());
    }

    private static void printRows(final List<Row> rows) {
        rows.forEach(OutputView::printRow);
        System.out.println();
    }

    private static void printRow(final Row row) {
        System.out.print(SPACE);
        for (int i = 0; i < row.getColumnSize() - 1; i++) {
            printBlock(row.hasVertexAt(i));
        }
        System.out.print(WALL);
        System.out.println();
    }

    private static void printBlock(boolean hasVertex) {
        System.out.print(WALL);
        if (hasVertex) {
            System.out.print(VERTEX);
            return;
        }
        System.out.print(SPACE);
    }


}
