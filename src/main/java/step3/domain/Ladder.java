package step3.domain;

import step3.utils.LadderUtil;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int maxHeight) {
        return new Ladder(createLines(countOfPerson, maxHeight));
    }

    private static List<Line> createLines(int countOfPerson, int maxHeight) {
        List<Line> list = new ArrayList<>();
        for (int j = 0; j < maxHeight; j++) {
            Line currentLine = Line.of(LadderUtil.isLine());
            list.add(currentLine);

            for (int i = 1; i < (countOfPerson - 1); i++) {
                currentLine = nextCreate(currentLine.getLine());
                list.add(currentLine);
            }
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
