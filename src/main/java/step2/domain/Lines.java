package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;
    private final Height height;

    public static Lines of(int countOfPerson, int height) {
        List<Line> newLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            newLine.add(new Line(countOfPerson));
        }
        return new Lines(newLine, height);
    }

    public Lines(List<Line> lines, int height) {
        this.lines = lines;
        this.height = new Height(height);
    }

    public List<Line> getLines() {
        return lines;
    }
}
