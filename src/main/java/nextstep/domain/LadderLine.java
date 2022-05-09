package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {
    private static final int WRITE_START = 1;
    private static final int LINE_LENGTH_FOR_USER = 5;
    private static final boolean USER_POINT = false;
    private final int userCount;
    private final List<Boolean> points = new ArrayList<>();

    public LadderLine(int userCount, int range) {
        this.userCount = userCount;
        writeLadderLine(range);
    }

    private void writeLadderLine(int range) {
        for (int i = WRITE_START; i < this.userCount; i++) {
            this.points.add(USER_POINT);
            this.points.addAll(writePoints(i, LadderLineGenerator.generate(range)));
        }
        this.points.add(USER_POINT);
    }

    private List<Boolean> writePoints(int i, boolean generate) {
        if(i == WRITE_START) {
            return write(generate);
        }
        if (!checkPoint(i) && i < this.userCount) {
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
        return points;
    }

}
