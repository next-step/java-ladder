package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

import java.util.List;

public class LadderResultView {

    public void printLadder(List<User> users, List<Line> lines) {
        printUsers(users);
        printLines(lines);
    }

    private void printLines(List<Line> lines) {
        for (Line line : lines) {
            StringBuilder sb = new StringBuilder("   ");
            sb.append("|");
            createLine(line, sb);
            System.out.println(sb);
        }
    }

    private void createLine(Line line, StringBuilder sb) {
        for (Boolean point : line.getPoints()) {
            if (point) {
                sb.append("-----");
            } else {
                sb.append("     ");
            }
            sb.append("|");
        }
    }

    private void printUsers(List<User> users) {
        StringBuilder nameString = new StringBuilder(users.get(0).getName());
        for (int i = 1; i < users.size(); i++) {
            nameString.append("  ");
            nameString.append(users.get(i).getName());
        }
        System.out.println(nameString);
    }
}
