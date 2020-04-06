package Ladder.view;

import Ladder.application.LadderController;
import Ladder.domain.*;

import java.util.Scanner;

public class LadderView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INSERT_NAME_SENTENCE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INSERT_MAXIMUM_LADDER_SENTENCE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_SENTENCE = "실행결과\n";
    private static final String OUTPUT_FORMAT = "%6s";
    private static final String VERTICAL_LINE_OF_LADDER = "|";
    private static final String HORIZON_LINE_OF_LADDER = "-----";
    private static final String NAME_SPLIT_DELIMITER = ",";

    public LadderView(final LadderController ladderController) {
        final LadderGame ladderGame = ladderController.start(
                getPlayerNames().split(NAME_SPLIT_DELIMITER), getLadderHeight());
        printGameResult(ladderGame);
    }

    private String getPlayerNames() {
        System.out.println(INSERT_NAME_SENTENCE);
        return SCANNER.next();
    }

    private int getLadderHeight() {
        System.out.println(INSERT_MAXIMUM_LADDER_SENTENCE);
        return SCANNER.nextInt();
    }

    private void printGameResult(final LadderGame ladderGame) {
        System.out.println(RESULT_SENTENCE);
        printPlayers(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
    }

    private void printPlayers(final Players players) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.getPlayersNumber(); i++) {
            sb.append(getPlayerNameWithOutputFormat(players.getPlayer(i)));
        }
        System.out.println(sb.toString());
    }

    private String getPlayerNameWithOutputFormat(final Player player) {
        return String.format(OUTPUT_FORMAT, player.getName());
    }

    private void printLadder(final Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i ++) {
            System.out.println(getLineDisplay(ladder.getLine(i)));
        }
    }

    private String getLineDisplay(final Line line) {
        final StringBuilder sb = new StringBuilder(String.format(OUTPUT_FORMAT, VERTICAL_LINE_OF_LADDER));

        for (int i = 0; i < line.getLineSize(); i++) {
            sb.append(getPointDisplay(line.getPoint(i)));
        }

        return String.format(OUTPUT_FORMAT, sb.toString());
    }

    private String getPointDisplay(final boolean point) {
        return String.format(OUTPUT_FORMAT, (point ? HORIZON_LINE_OF_LADDER : "") + VERTICAL_LINE_OF_LADDER);
    }
}
