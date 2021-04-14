package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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

    public void mark(int targetVertical, int targetHorizon) {
        this.lines.get(targetVertical).markOne(targetHorizon);
    }

    public String lineString(int targetVertical) {
        return this.lines.get(targetVertical).lineString();
    }

    public void initMark() {
        this.lines.get(0).markRandom();
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
                    bottomLine.getPoints().markOne(target, true);
                }
            }
        }
    }

    public void markWithoutFirst() {
        AtomicInteger i = new AtomicInteger(1);
        this.lines.stream()
                .forEach(l -> {
                    if (i.get() < this.lines.size()) {{
                        Line line = this.lines.get(i.getAndIncrement());
                        l.markRandom(line);
                    }}
                });
    }
}
