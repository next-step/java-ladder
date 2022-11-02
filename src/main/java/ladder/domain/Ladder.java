package ladder.domain;

import static ladder.domain.LineFactory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final int countOfPerson;
    private final int height;

    public Ladder(Users users, int height) {
        this.countOfPerson = users.count();
        this.height = height;
    }
    
    public Ladder(final int countOfPerson, final int height) {
        if (countOfPerson < 1 || height < 1) {
            throw new IllegalArgumentException("Number of people or height is greater than 1.");
        }
        this.countOfPerson = countOfPerson;
        this.height = height;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(createLines(countOfPerson, height));
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
}
