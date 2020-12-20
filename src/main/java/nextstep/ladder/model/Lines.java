package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }

    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
