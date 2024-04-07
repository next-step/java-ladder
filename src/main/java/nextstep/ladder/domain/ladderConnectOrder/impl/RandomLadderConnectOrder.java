package nextstep.ladder.domain.ladderConnectOrder.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.ladderConnectOrder.LadderConnectOrder;
import nextstep.ladder.domain.line.Point;

public class RandomLadderConnectOrder implements LadderConnectOrder {

    private final List<Boolean> values;
    private static final Random random = new Random();

    public RandomLadderConnectOrder(List<Boolean> values) {
        this.values = values;
    }

    public static List<LadderConnectOrder> createLadderConnectOrders(int height, int countOfPerson) {
        return IntStream.range(0, height)
            .mapToObj(i -> new RandomLadderConnectOrder(createLadderConnectOrder(countOfPerson)))
            .collect(Collectors.toList());
    }

    public static List<Boolean> createLadderConnectOrder(int countOfPerson) {
        return IntStream.range(0, countOfPerson - 1)
            .mapToObj(i -> random.nextBoolean())
            .collect(Collectors.toList());
    }

    public List<Point> connectLadder() {
        Point previousPoint = new Point(false);
        List<Point> points = new ArrayList<>();

        for (Boolean value : values) {
            previousPoint = addLineValue(previousPoint, value);
            points.add(previousPoint);
        }
        return points;
    }

    private Point addLineValue(Point previousPoint, boolean value) {
        return previousPoint.decideNextPoint(value);
    }
}
