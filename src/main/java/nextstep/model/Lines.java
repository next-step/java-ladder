package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static nextstep.constant.Constant.*;

public class Lines {
    private final List<Line> lines;
    private final int countOfPerson;

    public Lines(int vertical, int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.lines = new ArrayList<>();
        for (int i = 0; i < vertical; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    public void initMark() {
        this.lines.get(0).markRandom();
    }

    public void markWithoutFirst() {
        for (int i = 1; i < this.lines.size(); i++) {
            Line top = this.lines.get(i - 1);
            this.lines.get(i).markRandom(top);
        }
    }

    public Points points(int row) {
        return this.lines.get(row).getPoints();
    }

    public int start(int playerIndex) {
        int focus = playerIndex;

        int index = 0;
        int limit = countOfPerson;
        int loopCount = 0;
        while (index < this.lines.size()) {
            if (loopCount > 10) {
                break;
            }
            loopCount++;
            Line line = this.lines.get(index);
            Points points = line.getPoints();

            long falseCount = points.points().stream()
                    .filter(p -> !p)
                    .count();
            if (falseCount == 0) {
                index++;
                continue;
            }

            if (focus == 0) {
                if (points.get(focus)) {
                    focus++;
                    index++;
                } else {
                    index++;
                }
                continue;
            }

            if (focus == limit) {
                if (points.get(focus - 1)) {
                    focus--;
                    index++;
                } else {
                    index++;
                }
                continue;
            }

            if (points.get(focus)) {
                focus++;
                index++;
                continue;
            }
            if (points.get(focus - 1)) {
                focus--;
                index++;
                continue;
            }

            index++;
        }
        return focus;
    }
}
