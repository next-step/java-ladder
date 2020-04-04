package JavaLadder.view;

import JavaLadder.domain.Ladder;
import JavaLadder.domain.Line;
import JavaLadder.domain.UserList;

import java.util.List;

public class OutputView {
    private static final String ACTION_RESULT = "실행결과";
    private static final String LADDER = "|";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";

    public void result(UserList userList, Ladder ladder){
        System.out.println(ACTION_RESULT);
        for (int i = 0; i < userList.size(); i++) {
            System.out.printf("%-7s",userList.getName(i));
        }

        System.out.println();
        for (int j = 0; j < ladder.size(); j++) {
            Line list = (Line) ladder.getLadder(j);
            System.out.printf("%7s", LADDER);
            for (int k = 0; k < list.size(); k++) {
                if (list.isLine(k)) {
                    System.out.printf(LINE_TRUE);
                    System.out.printf("%s", LADDER);
                }

                if (!list.isLine(k)) {
                    System.out.printf(LINE_FALSE);
                    System.out.printf("%s", LADDER);
                }
            }
            System.out.println();
        }
    }
}
