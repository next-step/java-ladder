package ladder.view;

import ladder.model.player.Player;
import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.player.Position;
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
    private LadderPrizes ladderPrizes;
    private GameResult gameResult;

    public ResultView(Players players, Rows rows, LadderPrizes ladderPrizes) {
        this.players = players;
        this.rows = rows;
        this.ladderPrizes = ladderPrizes;
    }

    public ResultView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public static ResultView of(GameResult gameResult) {
        return new ResultView(gameResult);
    }

    public static ResultView of(Players players, Rows rows, LadderPrizes ladderPrizes) {
        return new ResultView(players, rows, ladderPrizes);
    }

    public void printLadder() {
        printTitle();
        printPlayers();
        printRows();
        printPrizes();
        printBlankLine();
    }

    public void printResult() {
        printBlankLine();
        printResultTitle();
        printGameResult();
    }

    public Players getPlayers() {
        return players;
    }

    public Rows getRows() {
        return rows;
    }

    public LadderPrizes getLadderPrizes() {
        return ladderPrizes;
    }

    private void printGameResult() {
        gameResult.getKeySet().stream()
                .map(it -> it.getName())
                .forEach(it -> System.out.println(it + DELIMITER_TO_PRINT + gameResult.findPrizeByPlayerName(it)));
        printBlankLine();
    }

    private void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    private void printPrizes() {
        ladderPrizes.getLadderPrizes().stream()
                .map(it -> it.getPrizeName())
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
                .map(PlayerName::getName)
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

    private String createBlanks(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(ONE_BLANK);
        }
        return stringBuilder.toString();
    }

    private void printOneRow(Row row) {
        printBlankPriorToRow();

        System.out.print(ONE_VERTICAL);
        for (int i = 0; i < players.getPlayers().size() - 1; i++) {
            printValue(row.getRowElement(new Position(i)));
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
}