package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class WidthGenerator {
    private List<Boolean> widthLines;

    public WidthGenerator(int personCount) {
        this.widthLines = generate(personCount);
    }

    public WidthGenerator(List<Boolean> widthLines) {
        this.widthLines = new ArrayList<>(widthLines);
    }

    public List<Boolean> getWidthLines() {
        return widthLines;
    }

    public List<Boolean> generate(int personCount) {
        List<Boolean> lines = new ArrayList<>();
        for (int line = 0, maxLine = personCount - 1; line < maxLine; line++) {
            lines.add(Math.round(Math.random()) < 0.5);
        }
        return lines;
    }
}
