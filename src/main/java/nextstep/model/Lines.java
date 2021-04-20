package nextstep.model;

import java.util.ArrayList;
import java.util.List;

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
        int limit = countOfPerson - 1;
        String arrow = (playerIndex == 0) ? RIGHT : LEFT;
        while (index < this.lines.size()) {
            Line line = this.lines.get(index);
            Points points = line.getPoints();

            if (focus == 0) {
                if (points.get(focus)) {
                    focus++;
                    arrow = RIGHT;
                } else {
                    index++;
                }
                continue;
            }

            if (focus == limit) {
                if (points.get(focus)) {
                    focus--;
                    arrow = LEFT;
                } else {
                    index++;
                }
                continue;
            }

            if (arrow.equals(LEFT)) {
                if (points.get(focus)) {
                    focus--;
                    if (focus == 0) {
                        arrow = RIGHT;
                    } else {
                        arrow = RIGHT;
                    }
                } else {
                    index++;
                }
                continue;
            }
            if (arrow.equals(RIGHT)) {
                if (points.get(focus)) {
                    focus++;
                    if (focus == limit) {
                        arrow = LEFT;
                    } else {
                        arrow = RIGHT;
                    }
                } else {
                    index++;
                }
                continue;
            }
        }
        return focus;
    }
}
