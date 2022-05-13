package nextstep.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {
    private static final int WRITE_START = 1;
    private static final int LINE_LENGTH_FOR_USER = 5;
    private static final boolean USER_POINT = false;
    private final List<Boolean> points = new ArrayList<>();

    public LadderLine(List<Boolean> isLadderGenerates) {
        writeLadderLine(isLadderGenerates);
    }

    private void writeLadderLine(List<Boolean> isLadderGenerates) {
        for (int i = WRITE_START; i <=isLadderGenerates.size(); i++) {
            this.points.add(USER_POINT);
            this.points.addAll(writePoints(i, isLadderGenerates.get(i - 1)));
        }
        this.points.add(USER_POINT);
    }

    private List<Boolean> writePoints(int i, boolean generate) {
        if(i == WRITE_START) {
            return write(generate);
        }
        if (!checkPoint(i)) {
            return write(generate);
        }
        return write(false);
    }

    private boolean checkPoint(int i) {
        return this.points.get((i - 1) * LINE_LENGTH_FOR_USER - 1);
    }

    private List<Boolean> write(boolean point) {
        return IntStream.range(0,LINE_LENGTH_FOR_USER)
                .mapToObj(idx -> point)
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
