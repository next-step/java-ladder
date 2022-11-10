package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<User> users = new ArrayList<>();
    private final List<Line> lines = new ArrayList<>();
    private String[] splitCommaName(String inputNames) {
        return inputNames.split(",");
    }

    public Ladder(int height, String inputNames) {
        String[] strings = splitCommaName(inputNames);
        for (String string : strings) {
            this.users.add(new User(string));
        }
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(strings.length));
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void printLadder() {
        StringBuilder nameString = new StringBuilder(users.get(0).getName());
        for (int i = 1; i < users.size(); i++) {
            nameString.append("  ");
            nameString.append(users.get(i).getName());
        }
        System.out.println(nameString);

        for (Line line : lines) {
            StringBuilder sb = new StringBuilder("   ");
            sb.append("|");
            for (Boolean point : line.getPoints()) {
                if (point) {
                    sb.append("-----");
                } else {
                    sb.append("     ");
                }
                sb.append("|");
            }
            System.out.println(sb);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
