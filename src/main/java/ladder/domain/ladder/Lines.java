package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public static Lines createManualLines(final int height, final int countOfPerson, final List<List<PointEnum>> points) {
        List<Line> newLines = new ArrayList<>();
        for (List<PointEnum> point : points) {
            newLines.add(Line.createManualLine(point));
        }

        if(newLines.size() != height) {
            throw new IllegalArgumentException("높이와 라인 수가 일치하지 않습니다.");
        }

        if(newLines.get(0).size() != countOfPerson - 1) {
            throw new IllegalArgumentException("사람 수와 포인트 수가 일치하지 않습니다.");
        }

        return new Lines(newLines);
    }

    public static Lines createRandomLines(final int height, final int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createRandomLine(countOfPerson));
        }
        return new Lines(lines);
    }


    public static Lines createLines(int height, int countOfPerson, LinesStrategy linesStrategy) {
        return linesStrategy.makeLines(height, countOfPerson);
    }

}
