package ladder.domain;

import static ladder.domain.LineFactory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Users users;
    private final Lines lines;

    public Ladder(final Users users, final Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines.lines());
    }
    
    public static Ladder of(final Users users, final int height, final Results results) {
        if (users.count() < 1 || height < 1) {
            throw new IllegalArgumentException("Number of people or height is greater than 1.");
        }
        return new Ladder(users, new Lines(createLines(users.count(), height), results));
    }

    public ExecutionResult getResultBy(final User user) {
        return new ExecutionResult(user, lines.findResultBy(users.getOrder(user)));
    }

    public List<ExecutionResult> getResult() {
        return users.getAll().stream().map(user -> getResultBy(user)).collect(Collectors.toList());
    }

    private static List<Line> createLines(final int countOfPerson, final int height) {
        List<Line> lines = new ArrayList<>();
        lines.add(edge(countOfPerson));
        for (int lineNumber = 1; lineNumber < height-1; lineNumber++) {
            lines.add(body(countOfPerson));
        }
        lines.add(edge(countOfPerson));
        return lines;
    }
}
