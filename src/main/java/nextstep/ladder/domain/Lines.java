package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    private Lines(LineGenerationStrategy lineGenerationStrategy, int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(lineGenerationStrategy, countOfPerson));
        }
    }

    public static Lines of(LineGenerationStrategy lineGenerationStrategy, int countOfPerson, int height) {
        return new Lines(lineGenerationStrategy, countOfPerson, height);
    }

    public List<Line> getLines() {
        return lines;
    }
}
