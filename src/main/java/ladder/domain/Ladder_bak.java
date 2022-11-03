package ladder.domain;

import javax.sound.sampled.Line;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder_bak {

    private final List<Line> lines;

    public Ladder_bak(List<Line> lines) {
        this.lines = lines;
    }
/*
    public static Ladder_bak of(int width, int height) {
        return Stream.generate(() -> Line.of(width - 1))
                .limit(height)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder_bak::new));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLadderEndIdx(int idx) {
        List<Line> lines = this.getLines();
        for (int i = 0; i < lines.size(); i++) {
            idx = moveNextLine(idx, i);
        }
        return idx;
    }

    private int moveNextLine(int idx, int row) {
        Line line = lines.get(row);
        boolean moved = false;

        if (line.canMoveRight(idx)) {
            idx = idx + 1;
            moved = true;
        }
        if (!moved && line.canMoveLeft(idx)) {
            idx = idx - 1;
        }
        return idx;
    }*/
}
