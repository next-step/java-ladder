package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenreator {
    private final int personCount;

    public LineGenreator(int personCount) {
        this.personCount = personCount;
    }

    public List<Boolean> generate() {
        List<Boolean> lines = new ArrayList<>();
        int maxLine = personCount - 1;
        for (int line = 0; line < maxLine; line++) {
            lines.add(Math.round(Math.random() * 9) < 0.5);
        }
        return lines;
    }
}
