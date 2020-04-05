package ladder.view;

import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Row;
import ladder.model.Rows;

public class ResultView {
    private static final String BORDER_LINE_TOP = "=============================";
    private static final String BLOCK_FALSE = "     ";
    private static final String BLOCK_TRUE = "-----";
    private static final String ONE_VERTICAL = "|";
    private static final String ONE_BLANK = " ";
    private static final String TITLE = "실행 결과";
    private static final int ONE_BLOCK_WIDTH = 6;

    private Players players;
    private Rows rows;

    public ResultView(Players players, Rows rows) {
        this.players = players;
        this.rows = rows;
    }

    public static ResultView of(Players players, Rows rows) {
        return new ResultView(players, rows);
    }

    public void printLadder() {
        printTitle();
        printPlayers();
        printRows();
    }

    private void printTitle() {
        System.out.println(BORDER_LINE_TOP);
        System.out.println(TITLE);
        printBlankLine();
    }

    private void printPlayers() {
        players.getPlayers().stream()
                .map(Player::getName)
                .map(it -> it + createBlanks(findNeededBlankCount(it)))
                .forEach(it -> System.out.print(it));
        printBlankLine();
    }

    private void printRows() {
        for (int i = 0; i < rows.getSize(); i++) {
            printOneRow(rows.getRowsElement(i));
        }
    }

    private int findNeededBlankCount(String name) {
        return (ONE_BLOCK_WIDTH - name.length());
    }

    private StringBuilder createBlanks(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(ONE_BLANK);
        }
        return stringBuilder;
    }

    private void printOneRow(Row row) {
        printBlankPriorToRow();

        System.out.print(ONE_VERTICAL);
        for (int i = 1; i < players.getPlayers().size(); i++) {
            printValue(row.getRowElement(i));
            System.out.print(ONE_VERTICAL);
        }

        printBlankLine();
    }

    private void printBlankPriorToRow() {
        for (int i = 0; i < 2; i++) {
            System.out.print(ONE_BLANK);
        }
    }

    private void printValue(boolean booleanValue) {
        String input = booleanValue ? BLOCK_TRUE : BLOCK_FALSE;
        System.out.print(input);
    }

    private void printBlankLine() {
        System.out.println();
    }
}