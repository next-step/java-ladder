package nextstep.ladder.util;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.*;

public class LadderBuilder {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public static Ladder build(Width width, Height height) {
        List<Points> ladder = Stream.generate(width::value)
            .map(LadderBuilder::buildPoints)
            .limit(height.value())
            .collect(Collectors.toUnmodifiableList());

        return new Ladder(ladder);
    }

    private static Points buildPoints(int width) {
        PointBuilder pointBuilder = new PointBuilder();

        List<Point> points = IntStream.range(0, width - 1)
            .mapToObj(position -> pointBuilder.build((RANDOM.nextBoolean()), position))
            .collect(Collectors.toList());

        points.add(pointBuilder.build(false, width - 1));

        return new Points(points);
    }

    static class PointBuilder {

        private boolean previous;

        private Point build(boolean current, int position) {
            if (this.previous) {
                this.previous = false;
                return new Point(position, LEFT);
            }

            if (current) {
                this.previous = true;
                return new Point(position, RIGHT);
            }

            return new Point(position, CENTER);
        }
    }
}