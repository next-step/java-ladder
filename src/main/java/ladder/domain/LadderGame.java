package ladder.domain;

import nextstep.optional.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private List<User> users;
    private List<Line> lines;
    private List<String> results;

    public LadderGame(List<User> users) {
        this.users = users;
        this.lines = createLine();
    }

    public LadderGame(List<User> users, List<String> resultList) {
        this(users);
        results = resultList;
    }

    private List<Line> createLine() {
        return IntStream.range(1, 5)
                .mapToObj(number -> new Line(users.size() - 1))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<String> drawUserList() {
        return users.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
    }

    public List<User>  start() {
        for (User user : users) {
            for (Line line : lines) {
                user.move(line);
            }
        }

        return users;
    }
}
