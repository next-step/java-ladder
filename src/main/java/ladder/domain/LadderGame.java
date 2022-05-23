package ladder.domain;

import ladder.domain.Line;
import ladder.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> drawUserList() {
        return users.stream()
                .map(user -> user.getUserName())
                .collect(Collectors.toList());
    }
}
