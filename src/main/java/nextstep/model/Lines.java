package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void mark(int targetVertical) {
        try {
            this.lines.get(targetVertical).mark();
        } catch (IllegalArgumentException e) {
            this.lines.get(targetVertical).reMark(this.lines.get(targetVertical - 1));
        }

    }

    public void mark(int targetVertical, int targetHorizon) {
        this.lines.get(targetVertical).mark(targetHorizon);
    }

    public String lineString(int targetVertical) {
        return this.lines.get(targetVertical).lineString();
    }

    public void initMark() {
        this.lines.get(0).initMark();
    }

    public void markSecond(int top, int bottom) {
        Line topLine = this.lines.get(top);
        Line bottomLine = this.lines.get(bottom);
        for (int i = 0; i < countOfPerson; i++) {
            if (topLine.getPoints().get(i)) {
                Random random = new Random();
                boolean nextBoolean = random.nextBoolean();
                int target = nextBoolean ? i - 1 : i + 1;
                if (target < 0 || target >= countOfPerson) {
                    nextBoolean = !nextBoolean;
                    target = nextBoolean ? i - 1 : i + 1;
                }
                if (target < 0 || target >= countOfPerson) {
                    continue;
                }
                if (!topLine.getPoints().get(target)) {
                    bottomLine.getPoints().set(target, true);
                }
            }
        }
    }
}
