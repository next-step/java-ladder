package ladder.ladder;

import ladder.line.Line;
import ladder.line.LineGenerateStrategy;
import ladder.line.move.Position;
import ladder.name.Names;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ladder {
    private static final int INIT = 0;

    private List<Line> lines = new ArrayList<>();

    public Ladder(Names names, Height height, LineGenerateStrategy lineGenerateStrategy) {
        this(names.getNames().size(), height.getValue(), lineGenerateStrategy);
    }

    public Ladder(int countOfPerson, int height, LineGenerateStrategy lineGenerateStrategy) {
        for (int i = INIT; i < height; i++) {
            lines.add(new Line(countOfPerson, lineGenerateStrategy));
        }
    }

    public List<Position> movePoints() {
        List<Position> positions = new ArrayList<>();

        int countOfPersons = lines.get(INIT).getLadderPositionSize();
        IntStream.range(INIT, countOfPersons)
                .mapToObj(Position::new)
                .map(this::move)
                .forEach(positions::add);

        return positions;
    }

    private Position move(Position position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(lines, ladder1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lines);
    }
}
