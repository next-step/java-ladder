package nextstep.model;

import java.util.ArrayList;
import java.util.List;

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
        Games games = new Games(playerIndex, countOfPerson);

        int index = 0;
        while (index < this.lines.size()) {
            Line line = this.lines.get(index);
            Points points = line.getPoints();

            long falseCount = points.points().stream()
                    .filter(p -> !p)
                    .count();
            index++;
            if (falseCount == 0) {
                continue;
            }

            if (games.isLeftBlock()) {
                games.toRightFocus();
                continue;
            }

            if (games.isRightBlock()) {
                games.toLeftFocus();
                continue;
            }

            if (games.isRightTrue(points)) {
                continue;
            }
            if (games.isLeftTrue(points)) {
                continue;
            }

            index++;
        }
        return games.focus;
    }
}
