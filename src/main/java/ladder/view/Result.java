package ladder.view;

import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.User;
import ladder.model.Users;

public class Result {
    private static final String NAME_FORMAT = "%5s ";
    private static final String LADDER_START_LINE = "    ";
    private static final String LADDER_END_LINE = "|";
    private static final String TRUE_TRUE_FALSE_LINE = "|-----|     ";
    private static final String TRUE_TRUE_LINE = "|-----";
    private static final String FALSE_LINE = "|     ";
    public static void printUsers(Users users) {
        for (User user : users.getParticipants()) {
            System.out.print( String.format(NAME_FORMAT, user.getName()));
        }
        System.out.println();
    }
    public static void printLadder(Lines lines) {
        for (Line line : lines.getLineList()) {
            System.out.print(LADDER_START_LINE);
            checkPrintPoint(line);
            System.out.println(LADDER_END_LINE);
        }
    }

    private static void checkPrintPoint(Line line) {
        for (int pointIndex=0; pointIndex < line.getPoints().size(); ) {
            pointIndex = printPoint(pointIndex, line);
        }
    }

    private static int printPoint(int pointIndex, Line line) {
        if (line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 2) {
            System.out.print(TRUE_TRUE_FALSE_LINE);
            return pointIndex += 2;
        }
        if (line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 1) {
            System.out.print(TRUE_TRUE_LINE);
        }
        if (!line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 1) {
            System.out.print(FALSE_LINE);
        }
        return ++pointIndex;
    }
}
