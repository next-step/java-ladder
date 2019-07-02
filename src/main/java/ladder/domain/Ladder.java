package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final PointGenerator pointGenerator = new RandomPointGenerator();
    private final Lines lines;
    private final int height;

    public Ladder(int width, int height) {

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("라인 개수 또는 길이가 유효하지 않습니다.");
        }

        this.lines = Lines.of(width, height, pointGenerator);
        this.height = height;
    }

    public List<Line> getLines() {

        return Collections.unmodifiableList(lines.getLines());
    }

    public int getHeight() {

        return height;
    }
}
