package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<User> users;
    private final List<Line> lines;
    private final int height;

    public Ladder(List<String> names, int height) {
        this.users = names.stream()
                          .map(User::new)
                          .collect(Collectors.toList());

        this.lines = new ArrayList<>();
        this.height = height;
        for (int i = 0; i < height; i++) {
            lines.add(new Line(users.size(), new RandomLineStrategy()));
        }
    }

    public int getCountOfPerson() {
        return users.size();
    }

    public Line getLine(int idx) {
        return lines.get(idx);
    }

    public String getUserName(int idx) {
        return users.get(idx).getName();
    }

    public int getHeight() {
        return height;
    }
}
