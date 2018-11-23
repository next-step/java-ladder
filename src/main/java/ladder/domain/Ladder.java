package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.Result.START_COLUMN;

public class Ladder {

    private List<Line> lines;

    private Ladder(int row, int countOfPerson) {
        lines = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            lines.add(Line.create(countOfPerson));
        }
    }

    public static Ladder create(int row, int countOfPerson) {
        return new Ladder(row, countOfPerson);
    }

    public static Ladder create(LadderOption ladderOption, Attendees attendees) {
        return new Ladder(ladderOption.height(), attendees.size());
    }

    public void drawLine() {
        lines.forEach(Line::draw);
    }

    public void drawLine(int countOfPerson) {
        for (int row = 0; row < lines.size(); row++) {
            Line line = lines.get(row);
            line.draw(RandomUtils.generate(countOfPerson));
        }
    }

    public int endpoint(int countOfPerson) {
        return follow(countOfPerson, START_COLUMN);
    }

    private int follow(int column, int row) {
        Line line = lines.get(row);

        column = column + line.step(column);
        row = row + 1;

        if(row < line.size() + 1) {
            return this.follow(column, row);
        }
        return column;
    }

    public int size() {
        return lines.size();
    }

    @Override
    public String toString() {
        return lines.stream().map(Line::toString).collect(Collectors.joining("\n"));
    }
}
