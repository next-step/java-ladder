package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Ladder {

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    private Ladder(Width width, Height height) {
        this(lines(width, height));
    }

    public static Ladder create(Width width, Height height) {
        return new Ladder(width, height);
    }

    public static Ladder create(LadderLine... ladderLines) {
        return new Ladder(Arrays.asList(ladderLines));
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    private static List<LadderLine> lines(Width width, Height height) {
        final List<LadderLine> ladderLines = new ArrayList<>(height.getLength());
        for (int i = 0; i < height.getLength(); i++) {
            ladderLines.add(LadderLine.createWithWidth(width));
        }
        return ladderLines.stream()
                .map(line -> LadderLine.create(randomLinePoints(width, Ladder::check)))
                .collect(Collectors.toList());
    }

    protected static List<Boolean> randomLinePoints(Width width, Checkable checkable) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width.getLength(); i++) {
            checkPoint(checkable.check(), points, i);
        }
        return points;
    }

    private static void checkPoint(boolean checkable, List<Boolean> points, int index) {

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

    private static boolean isFirst(int index) {
        return index == 0;
    }

    private static int previous(int index) {
        return index - 1;
    }

    private static boolean check() {
        return Math.random() < 0.5;
    }

    public int getHeight() {
        return this.ladderLines.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
