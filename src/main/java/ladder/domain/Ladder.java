package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

    private final Width width;

    private final Height height;

    private final List<Line> lines;

    private Ladder(Width width, Height height) {
        this.width = width;
        this.height = height;
        this.lines = initLines(width, height);
    }

    public static Ladder create(Width width, Height height) {
        return new Ladder(width, height);
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> initLines(Width width, Height height) {
        final List<Line> lines = new ArrayList<>(height.getLength());
        for (int i = 0; i < height.getLength(); i++) {
            lines.add(Line.createWithWidth(width));
        }
        return lines.stream()
                .map(line -> Line.create(randomLinePoints(width, Ladder::check)))
                .collect(Collectors.toList());
    }

    protected List<Boolean> randomLinePoints(Width width, Checkable checkable) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width.getLength(); i++) {
            checkPoint(checkable.check(), points, i);
        }
        return points;
    }

    private void checkPoint(boolean checkable, List<Boolean> points, int index) {

        if (!checkable) {
            points.add(false);
            return;
        }

        if (isFirst(index)) {
            points.add(true);
            return;
        }

        if (!points.get(previous(index))) {
            points.add(true);
            return;
        }

        points.add(false);

    }

    private boolean isFirst(int index) {
        return index == 0;
    }

    private int previous(int index) {
        return index - 1;
    }

    private static boolean check() {
        return Math.random() < 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(width, ladder.width) && Objects.equals(height, ladder.height) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, lines);
    }
}
