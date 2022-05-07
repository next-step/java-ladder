package nextstep.ladder.domain;

import nextstep.ladder.exception.InvalidLadderException;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.domain.LineFactory.*;

public class Ladder {

    private final List<Line> lines;
    private final int width;

    Ladder(List<Line> lines, int width) {
        if (width <= 0 || lines.isEmpty()) {
            throw new InvalidLadderException(width, lines.size());
        }
        this.lines = lines;
        this.width = width;
    }

    public static Ladder createRandomLadder(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new InvalidLadderException(width, height);
        }
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLineOfWidth(width));
        }
        return new Ladder(lines, width);
    }

    public void apply(Participants participants) {
        lines.forEach(line -> line.apply(participants));
    }

    public int getWidth() {
        return width;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
