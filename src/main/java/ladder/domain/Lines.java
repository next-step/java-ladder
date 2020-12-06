package ladder.domain;

import ladder.utils.LadderUtil;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPerson) {
        return new Lines(createLines(countOfPerson));
    }

    private static List<Line> createLines(int countOfPerson) {
        List<Line> list = new ArrayList<>();
        Line currentLine = Line.of(LadderUtil.isLine());
        list.add(currentLine);
        for (int i = 1; i < (countOfPerson - 1); i++) {
            currentLine = nextCreate(currentLine.getLine());
            list.add(currentLine);
        }
        return list;
    }

    private static Line nextCreate(boolean isLine) {
        boolean isNextLine = LadderUtil.isLine();
        if (isLine == isNextLine) {
            return Line.of(!isNextLine);
        }
        return Line.of(isNextLine);
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
