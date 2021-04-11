package step2;

import step2.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int countOfPerson) {
        this.lines = createLines(height, countOfPerson);
    }

    private List<Line> createLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
