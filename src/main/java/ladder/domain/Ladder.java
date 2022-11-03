package ladder.domain;

import static ladder.domain.LineFactory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(final Lines lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines.lines());
    }
    
    public static Ladder of(final Users users, final int height, final Result result) {
        if (users.count() < 1 || height < 1) {
            throw new IllegalArgumentException("Number of people or height is greater than 1.");
        }
        return new Ladder(new Lines(createLines(users.count(), height), result));
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

    public String getResultBy(final Users users, final User user) {
        int userIndex = users.find(user);
        return lines.findResultBy(userIndex);
    }
}
