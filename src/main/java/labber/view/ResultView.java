package labber.view;

import labber.domain.Ladder;
import labber.domain.Line;
import labber.domain.User;
import labber.domain.Users;

public class ResultView {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String LADDER_LENGTH = "|";
    private static final String NO_LADDER = "     ";
    private static final String LADDER = "-----";
    private static final int INIT_NUMBER = 0;

    public static void printResult(Users users, Ladder ladder) {
        System.out.println(EXECUTION_RESULT);

        for (User user : users.getUsers()) {
            System.out.print(user.getName() + " ");
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            STRING_BUILDER.append(LADDER_LENGTH);
            for (Boolean points : line.getPoints()) {
                if (!points) {
                    STRING_BUILDER.append(NO_LADDER);
                    STRING_BUILDER.append(LADDER_LENGTH);
                    continue;
                }
                STRING_BUILDER.append(LADDER);
                STRING_BUILDER.append(LADDER_LENGTH);
            }
            System.out.println(STRING_BUILDER);
            STRING_BUILDER.setLength(INIT_NUMBER);
        }
    }
}
