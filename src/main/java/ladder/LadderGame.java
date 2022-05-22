package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private List<User> users;

    public LadderGame(List<User> users) {
        this.users = users;
    }

    public List<Line> ready() {
        int maxLine = users.size() - 1;
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lines.add(new Line(maxLine));
        }

        return lines;
    }
}
