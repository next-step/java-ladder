package ladder.domain;

import ladder.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    public List<Line> lines() {
        return lines;
    }

    public static Ladder create(int width, int height, ValueGenerateStrategy valueGenerateStrategy) {
        validateHeight(height);
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = Line.create(width, valueGenerateStrategy);
            lines.add(line);
        }
        return new Ladder(lines);
    }

    private void validateLines(List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("사다리를 구성하는 라인들은 null 일 수 없습니다.");
        }
    }

    private static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 1 이상이어야 합니다. 입력 받은 사다리 높이 : %d", height));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder ladder = (Ladder) o;

        return lines.equals(ladder.lines);
    }

    @Override
    public int hashCode() {
        return lines.hashCode();
    }
}
