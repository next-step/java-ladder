package ladder.domain;

import static ladder.domain.LineFactory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final int height;
    private final Result result;
    private final Users users;

    public Ladder(final Users users, final int height, final Result result) {
        if (users.count() < 1 || height < 1) {
            throw new IllegalArgumentException("Number of people or height is greater than 1.");
        }
        this.users = users;
        this.height = height;
        this.result = result;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(createLines(users.count(), height));
    }

    private List<Line> createLines(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        lines.add(edge(countOfPerson));
        for (int lineNumber = 1; lineNumber < height-1; lineNumber++) {
            lines.add(body(countOfPerson));
        }
        lines.add(edge(countOfPerson));
        return lines;
    }

    public List<String> getResult() {
        return result.getAll();
    }
}
