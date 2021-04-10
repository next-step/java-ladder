package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.StreamUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineFactory implements LineFactory {

    private static final Random RANDOM = new Random();

    @Override
    public Line createLine(int numberOfPoints) {
        List<Point> points = IntStream.range(0, numberOfPoints)
                                      .mapToObj(Point::of)
                                      .collect(Collectors.toList());

        StreamUtils.pairStream(points)
                   .forEach(pair -> tryToConnect(pair.getFirst(), pair.getSecond()));

        return new Line(points);
    }

    private void tryToConnect(Point leftPoint, Point rightPoint) {
        if (!leftPoint.isConnectedAnotherPoint() && RANDOM.nextBoolean()) {
            leftPoint.connectTo(rightPoint);
            rightPoint.connectTo(leftPoint);
        }
    }

}
