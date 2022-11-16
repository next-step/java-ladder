package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

import java.util.List;

public class LadderResultView {

    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String DIVISION_LINE = "|";

    public void printLadder(List<User> users, List<Line> lines) {
        printUsers(users);
        printLines(lines);
    }

    private void printLines(List<Line> lines) {
        for (Line line : lines) {
            StringBuilder sb = new StringBuilder(BLANK);
            createLine(line, sb);
            sb.append(DIVISION_LINE);
            System.out.println(sb);
        }
    }

    private void createLine(Line line, StringBuilder sb) {
        for (Boolean point : line.getPoints()) {
            sb.append(DIVISION_LINE);
            sb.append(printLineByPoint(point));
        }
    }

    private String printLineByPoint(boolean point) {
        if (point) return LINE;
        return BLANK;
    }

    private void printUsers(List<User> users) {
        StringBuilder nameString = new StringBuilder();
        for (User user : users) {
            nameString.append(formattingUserName(user.getName()));
        }
        System.out.println(nameString);
    }

    private String formattingUserName(String userName) {
        int columnLength = LINE.length() + DIVISION_LINE.length();
        return String.format("%" + columnLength + "s", userName);
    }
}
