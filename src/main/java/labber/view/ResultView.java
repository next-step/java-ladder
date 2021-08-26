package labber.view;

import labber.domain.Ladder;
import labber.domain.Line;
import labber.domain.User;
import labber.domain.Users;

public class ResultView {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String EXECUTION_RESULT = "실행 결과";


    public static void printResult(Users users, Ladder ladder) {
        System.out.println(EXECUTION_RESULT);

        for (User user : users.getUsers()) {
            System.out.print(user.getName() + " ");
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            STRING_BUILDER.append("|");
            for (Boolean points : line.getPoints()) {
                if (points == false) {
                    STRING_BUILDER.append("     ");
                    STRING_BUILDER.append("|");
                    continue;
                }
                STRING_BUILDER.append("-----");
                STRING_BUILDER.append("|");
            }
            System.out.println(STRING_BUILDER);
            STRING_BUILDER.setLength(0);
        }
    }
}
