package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.List;

public class ResultView {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String LADDER_LENGTH = "|";
    private static final String NO_LADDER = "     ";
    private static final String LADDER = "-----";
    private static final int INIT_NUMBER = 0;
    private static final int USER_DRAW_LENGTH = 6;


    public static void printUserList(Users users) {
        System.out.println(EXECUTION_RESULT);
        for (User user : users.getUsers()) {
            System.out.print(userDrawingFormat(user));
            STRING_BUILDER.setLength(INIT_NUMBER);
        }
        System.out.println();
    }

    private static StringBuilder userDrawingFormat(User user) {
        STRING_BUILDER.append(user.getName());
        int gap = USER_DRAW_LENGTH - user.getName().length();
        for (int i = 0; i < gap; i++) {
            STRING_BUILDER.append(" ");
        }
        return STRING_BUILDER;
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

}
