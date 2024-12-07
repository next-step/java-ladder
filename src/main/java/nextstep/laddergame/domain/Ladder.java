package nextstep.laddergame.domain;

import nextstep.laddergame.service.PlayResult;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public PlayResult play(int participantsSize) {
        PlayResult result = new PlayResult();
        for (int position = 0; position < participantsSize; position++) {
            result.add(position, move(position));
        }
        return result;
    }

    private int move(int position) {
        for(Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> values() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
