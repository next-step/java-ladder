package JavaLadder.view;

import JavaLadder.domain.*;

public class OutputView {
    private static final String LADDER_RESULT = "사다리결과";
    private static final String ACTION_RESULT = "실행 결과";
    private static final String LADDER = "|";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";

    public void showLadder(UserList userList, Ladder ladder, PrizeList prizeList) {
        System.out.println(LADDER_RESULT);
        printName(userList);
        printLadder(ladder);
        printPrize(prizeList);
    }

    private void printPrize(PrizeList prizeList) {
        for (int i = 0; i < prizeList.size(); i++) {
            System.out.printf("%-6s", prizeList.getPrize(i));
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            Line list = (Line) ladder.getLadder(i);
            System.out.printf("%s", LADDER);
            printLine(list);
            System.out.println();
        }
        System.out.println();
    }

    private void printName(UserList userList) {
        for (int i = 0; i < userList.size(); i++) {
            System.out.printf("%-6s", userList.getName(i));
        }
        System.out.println();
    }

    private void printLine(Line list) {
        for (int i = 0; i < list.size(); i++) {
            printLine(list.isLine(i), LINE_TRUE);
            printLine(!list.isLine(i), LINE_FALSE);
        }
    }

    private void printLine(Boolean line, String lineKind) {
        if (line) {
            System.out.printf(lineKind);
            System.out.printf("%s", LADDER);
        }
    }

    public void showResult(ResultList resultList, PrizeList prizeList) {
        System.out.println(ACTION_RESULT);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.getResultName(i) + " : " + prizeList.getPrize(resultList.getResultPoint(i)));
        }
    }
}
