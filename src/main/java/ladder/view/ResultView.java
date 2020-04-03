package ladder.view;

import ladder.model.Player;
import ladder.model.Row;
import ladder.model.Rows;

import java.util.List;

public class ResultView {
    private static final String BORDER_LINE_TOP = "=============================";
    private static final String BLOCK_FALSE = "     ";
    private static final String BLOCK_TRUE = "-----";
    private static final String ONE_VERTICAL = "|";
    private static final String ONE_BLANK = " ";
    private static final String TITLE = "실행 결과";
    private static final int ONE_BLOCK_WIDTH = 6;

    private static List<Player> players;

    public static void printLadder(List<Player> allPlayers, Rows rows) {
        printTitle();
        printPlayers(allPlayers);
        printRows(rows);
    }

    private static void printTitle() {
        System.out.println(BORDER_LINE_TOP);
        System.out.println(TITLE);
        printBlankLine();
    }

    private static void printPlayers(List<Player> allPlayers) {
        players = allPlayers;
        allPlayers.stream()
                .map(Player::getName)
                .map(it -> it + createBlanks(findNeededBlankCount(it)))
                .forEach(it -> System.out.print(it));
        printBlankLine();
    }

    private static void printRows(Rows rows) {
        for (int i = 0; i < rows.getSize(); i++) {
            printOneRow(rows.getRowsElement(i));
        }
    }

    private static int findNeededBlankCount(String name) {
        return (ONE_BLOCK_WIDTH - name.length());
    }

    private static StringBuilder createBlanks(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(ONE_BLANK);
        }
        return stringBuilder;
    }

    private static void printOneRow(Row row) {
        printBlankPriorToRow();

        System.out.print(ONE_VERTICAL);
        for (int i = 1; i < players.size(); i++) {
            printValue(row.getRowElement(i));
            System.out.print(ONE_VERTICAL);
        }

        printBlankLine();
    }

    private static void printBlankPriorToRow() {
        for (int i = 0; i < 2; i++) {
            System.out.print(ONE_BLANK);
        }
    }

    private static void printValue(boolean booleanValue) {
        String input = booleanValue ? BLOCK_TRUE : BLOCK_FALSE;
        System.out.print(input);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}