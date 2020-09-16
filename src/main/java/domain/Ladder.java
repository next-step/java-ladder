package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder() {
        lines = new ArrayList<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void makeLines(String[] inputs, int height) {
        int countOfPerson = inputs.length;

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }
}
