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
        Games games = new Games(countOfPerson, playerIndex);

        int index = 0;
        while (index < this.lines.size()) {
            Line line = this.lines.get(index);
            Points points = line.getPoints();

            long falseCount = points.points().stream()
                    .filter(p -> !p)
                    .count();

            if (falseCount == 0) {
                index++;
                continue;
            }

            if (games.isLeftBlock()) {
                games.isRightTrue(points);
                index++;
                continue;
            }

            if (games.isRightBlock()) {
                games.isLeftTrue(points);
                index++;
                continue;
            }

            if (games.isRightTrue(points)) {
                index++;
                continue;
            }
            if (games.isLeftTrue(points)) {
                index++;
                continue;
            }

            index++;
        }
        return games.focus;
    }
}
