package step3.domain;

import step3.utils.LadderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Lines> lines;

    private Ladder(List<Lines> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int maxHeight) {
        return new Ladder(createLines(countOfPerson, maxHeight));
    }

    private static List<Lines> createLines(int countOfPerson, int maxHeight) {
        return Stream.generate(() -> Lines.of(createLine(countOfPerson)))
                .limit(maxHeight)
                .collect(Collectors.toList());
    }

    private static List<Line> createLine(int countOfPerson) {
        List<Line> list = new ArrayList<>();
        Line currentLine = Line.of(LadderUtil.isLine());
        list.add(currentLine);

        for (int i = 1; i < countOfPerson - 1; i++) {
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

    public List<Lines> getLines() {
        return this.lines;
    }
}
