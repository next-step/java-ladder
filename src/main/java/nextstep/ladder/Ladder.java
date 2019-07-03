package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();
    private List<User> users;

    private Ladder() {
    }

    public Ladder(int height, List<User> users, BooleanFunction booleanFunction) {
        this.users = users;
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(users.size(), booleanFunction))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<User> getUsers() {
        return users;
    }
}
