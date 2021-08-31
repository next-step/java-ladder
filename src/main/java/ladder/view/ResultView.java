package ladder.view;

import ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String LADDER_LENGTH = "|";
    private static final String NO_LADDER = "     ";
    private static final String LADDER = "-----";
    private static final int INIT_NUMBER = 0;

    public static void printUserList(Users users) {
        System.out.println(LADDER_RESULT);
        for (User user : users.getUsers()) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            drawLine(line.getPoints());
            System.out.println(STRING_BUILDER);
            STRING_BUILDER.setLength(INIT_NUMBER);
        }
    }

    private static void drawLine(List<Boolean> points) {
        STRING_BUILDER.append(LADDER_LENGTH);
        for (Boolean point : points) {
            if (!point) {
                STRING_BUILDER.append(NO_LADDER);
                STRING_BUILDER.append(LADDER_LENGTH);
                continue;
            }
            STRING_BUILDER.append(LADDER);
            STRING_BUILDER.append(LADDER_LENGTH);
        }
    }

    public static void printWinningItems(WinningItems winningItems) {
        for (WinningItem item : winningItems.getWinningItems()) {
            System.out.printf("%-6s", item.getItem());
        }
        System.out.println();
    }

    public static void printResult(MatchResults matchResults, User user) {
        System.out.println(EXECUTION_RESULT);
        Result result = matchResults.resultToUser(user);
        System.out.println(result.getUser().getName() + " : " + result.getWinningItem().getItem());
    }

    public static void printAllResult(MatchResults matchResults) {
        System.out.println(EXECUTION_RESULT);

        List<Result> results = matchResults.getResults();
        for (Result result : results) {
            System.out.println(result.getUser().getName() + " : " + result.getWinningItem().getItem());
        }
    }

}
