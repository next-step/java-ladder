package ladder.view;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Row;
import ladder.model.row.Rows;

public class ResultView {
    private static final String BORDER_LINE_TOP = "=============================";
    private static final String BLOCK_FALSE = "     ";
    private static final String BLOCK_TRUE = "-----";
    private static final String ONE_VERTICAL = "|";
    private static final String ONE_BLANK = " ";
    private static final String DELIMITER_TO_PRINT = " : ";
    private static final String LADDER_TITLE = "사다리 게임 결과";
    private static final String RESULT_TITLE = "실행 결과";
    private static final int ONE_BLOCK_WIDTH = 6;
    private static final double HALF_BLOCK_WIDTH = 2.5;

    private Players players;
    private Rows rows;

    public ResultView(Players players, Rows rows) {
        this.players = players;
        this.rows = rows;
    }

    public static ResultView of(Players players, Rows rows) {
        return new ResultView(players, rows);
    }

    public void printLadder(LadderPrizes ladderPrizes) {
        printTitle();
        printPlayers();
        printRows();
        printPrizes(ladderPrizes);
        printBlankLine();
    }

    public static void printResult(GameResult gameResult) {
        printBlankLines();
        printResultTitle();
        printGameResult(gameResult);
    }

    private static void printGameResult(GameResult gameResult) {
        gameResult.getKeySet().stream()
                .forEach(it -> System.out.println(it + DELIMITER_TO_PRINT + gameResult.findPrizeByPlayerName(it)));
        printBlankLines();
    }

    private static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    private void printPrizes(LadderPrizes ladderPrizes) {
        ladderPrizes.getLadderPrizes().stream()
                .map(it -> it.getPrizeName())
                .map(it -> createBlanks(findBlankCountBefore(it)) + it + createBlanks(findBlankCountAfter(it)))
                .forEach(it -> System.out.print(it));
        printBlankLine();
    }

    private void printTitle() {
        System.out.println(BORDER_LINE_TOP);
        System.out.println(LADDER_TITLE);
        printBlankLine();
    }

    private void printPlayers() {
        players.getPlayers().stream()
                .map(Player::getName)
                .map(it -> createBlanks(findBlankCountBefore(it)) + it + createBlanks(findBlankCountAfter(it)))
                .forEach(it -> System.out.print(it));
        printBlankLine();
    }

    private void printRows() {
        for (int i = 0; i < rows.getSize(); i++) {
            printOneRow(rows.getRowsElement(i));
        }
    }

    private int findBlankCountBefore(String name) {
        return (int) Math.ceil((ONE_BLOCK_WIDTH - name.length()) / HALF_BLOCK_WIDTH);
    }

    private int findBlankCountAfter(String name) {
        return (int) Math.round((ONE_BLOCK_WIDTH - name.length()) / HALF_BLOCK_WIDTH);
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
        for (int i = 0; i < players.getPlayers().size() - 1; i++) {
            printValue(row.getRowElement(i));
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
        System.out.print(ONE_VERTICAL);
    }

    private void printBlankLine() {
        System.out.println();
    }

    private static void printBlankLines() {
        System.out.println();
    }
}