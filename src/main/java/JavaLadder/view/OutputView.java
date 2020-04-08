package JavaLadder.view;

import JavaLadder.domain.*;

public class OutputView {
    private static final String LADDER_RESULT = "사다리결과";
    private static final String ACTION_RESULT = "실행 결과";
    private static final String LADDER = "|";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";

    public void showLadder(GameInformation gameInformation, Ladder ladder) {
        Users users = gameInformation.getUser();
        Prizes prizes = gameInformation.getPrizes();
        System.out.println(LADDER_RESULT);
        printName(users);
        printLadder(ladder);
        printPrize(prizes);
    }

    private void printPrize(Prizes prizes) {
        for (int i = 0; i < prizes.size(); i++) {
            System.out.printf("%-6s", prizes.getPrize(i));
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            Line list = (Line) ladder.getLineByLadder(i);
            System.out.printf("%s", LADDER);
            printLine(list);
            System.out.println();
        }
        System.out.println();
    }

    private void printName(Users users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%-6s", users.getName(i));
        }
        System.out.println();
    }

    private void printLine(Line list) {
        for (int i = 0; i < list.size(); i++) {
            printLine(list.isTrue(i), LINE_TRUE);
            printLine(!list.isTrue(i), LINE_FALSE);
        }
    }

    private void printLine(Boolean line, String lineKind) {
        if (line) {
            System.out.printf(lineKind);
            System.out.printf("%s", LADDER);
        }
    }

    public void showResult(Results results, GameInformation gameInformation) {
        Prizes prizes = gameInformation.getPrizes();
        System.out.println(ACTION_RESULT);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.getResultName(i) + " : " + prizes.getPrize(results.getResultPoint(i)));
        }
    }
}