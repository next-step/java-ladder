package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    public static final int START = 0;

    private final List<Line> lines;

    public Ladder(Users users, int height) {
        lines = new ArrayList<>();
        IntStream.range(START, height)
                .forEach(i -> lines.add(new Line(users.getUsers().size())));
    }

    public List<Line> getLines() {
        return lines;
    }
}
