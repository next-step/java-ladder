package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<User> users;

    public LadderGame(List<User> users) {
        this.users = users;
    }

    public List<Line> ready() {
        return IntStream.range(1, 5)
                .mapToObj(number -> new Line(users.size() - 1))
                .collect(Collectors.toList());
    }

    public List<String> drawUserList() {
        return users.stream()
                .map(user -> user.toString())
                .collect(Collectors.toList());
    }
}
