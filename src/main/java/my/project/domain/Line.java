package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created : 2020-12-04 오전 10:26
 * Developer : Seo
 */
public class Line {
    private final List<Symbol> points = new ArrayList<>();

    public Line(int countOfPerson) {
        int endExclusive = countOfPerson + countOfPerson - 1;

        IntStream.range(0, endExclusive)
                .forEach(y -> {
                    if (isVertical(y)) {
                        this.points.add(Symbol.VERTICAL);
                        return;
                    }
                    if (isBridge(y)) {
                        this.points.add(Symbol.BRIDGE);
                        return;
                    }
                    this.points.add(Symbol.NONE);
                });
    }

    private boolean isVertical(int i) {
        return i % 2 == 0;
    }

    private boolean isBridge(int y) {
        boolean target = new Random().nextInt(2) % 2 == 0;

        if (target && y < 2) {
            return true;
        }
        return target && points.get(y - 2) != Symbol.BRIDGE;
    }

    public List<Symbol> getPoints() {
        return points;
    }
}
