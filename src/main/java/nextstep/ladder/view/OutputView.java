package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {

    private static final int NEXT_WIDTH_NUMBER = 1;
    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 1;
    private static final int NAME_PADDING_RANGE = 5;
    private static final int RESULT_PADDING_RANGE = 5;

    private static final String ALL_USER = "all";

    private static final String HEIGHT_SEPARATOR = "|";
    private static final String LINE_SEPARATOR = "-----";
    private static final String NOT_LINE_SEPARATOR = "     ";

    private static final String USER_RESULT_FORMAT = "%s : %s";

    private static final String LADDER_MENT = "사다리 결과";
    private static final String RESULT_MENT = "실행 결과";

    public static void drawLadder(final LadderGame ladderGame, Results results) {
        System.out.println(LADDER_MENT);
        System.out.println();
        drawLadderUsers(ladderGame);
        for (int height = 0; height < ladderGame.ladderHeight(); height++) {
            drawLadderHeight(ladderGame, height);
        }
        drawLadderResults(results);
    }

    private static void drawLadderUsers(final LadderGame ladderGame) {
        for (String name : ladderGame.inGameUserNames()) {
            System.out.printf("%-" + NAME_PADDING_RANGE + "s ", name);
        }
        System.out.println();
    }

    private static void drawLadderHeight(final LadderGame ladderGame, int height) {
        for (int width = 0; width < ladderGame.ladderWidth() - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER; width++) {
            System.out.print(HEIGHT_SEPARATOR);
            drawLadderLine(ladderGame, width, height);
        }
        System.out.print(HEIGHT_SEPARATOR);
        System.out.println();
    }

    private static void drawLadderLine(final LadderGame ladderGame, int width, int height) {
        if (ladderGame.ladderHasLine(makeLine(width, height))) {
            System.out.print(LINE_SEPARATOR);
            return;
        }
        System.out.print(NOT_LINE_SEPARATOR);
    }

    private static Line makeLine(final int width, final int height) {
        return new Line(new Position(width, height), new Position(width + NEXT_WIDTH_NUMBER, height));
    }

    private static void drawLadderResults(final Results results) {
        for (String result : results.results()) {
            System.out.printf("%-" + RESULT_PADDING_RANGE + "s ", result);
        }
        System.out.println();
    }

    public static void drawResult(final LadderGame ladderGame, final Results results, final String userName) {
        if (userName.equals(ALL_USER)) {
            drawAllResult(ladderGame, results);
            return;
        }
        drawUserResult(ladderGame, results, userName);
    }

    private static void drawUserResult(final LadderGame ladderGame, final Results results, final String userName) {
        System.out.println(RESULT_MENT);
        System.out.println(results.reuslt(ladderGame.userCurrentPosition(userName)));

    }

    private static void drawAllResult(final LadderGame ladderGame, final Results results) {
        System.out.println(RESULT_MENT);
        for (String userName : ladderGame.inGameUserNames()) {
            System.out.printf(USER_RESULT_FORMAT, userName, results.reuslt(ladderGame.userCurrentPosition(userName)));
            newLine();
        }
    }

    private static void newLine() {
        System.out.println();
    }

}
