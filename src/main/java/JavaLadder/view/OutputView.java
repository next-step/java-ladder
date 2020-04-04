package JavaLadder.view;

import JavaLadder.domain.Ladder;
import JavaLadder.domain.Line;
import JavaLadder.domain.UserList;

public class OutputView {
    private static final String ACTION_RESULT = "실행결과";
    private static final String LADDER = "|";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";

    public void result(UserList userList, Ladder ladder) {
        System.out.println(ACTION_RESULT);
        PrintName(userList);
        System.out.println();
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            Line list = (Line) ladder.getLadder(i);
            System.out.printf("%7s", LADDER);
            printLine(list);
            System.out.println();
        }
    }

    private void PrintName(UserList userList) {
        for (int i = 0; i < userList.size(); i++) {
            System.out.printf("%-7s", userList.getName(i));
        }
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
}
