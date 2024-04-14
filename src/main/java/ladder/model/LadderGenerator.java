package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    public static Ladder generateLadder(int heightOfLadder, Participants participants, LadderGeneratorStrategy strategy) {
        List<Line> ladder = IntStream.range(0, heightOfLadder)
                .mapToObj(i -> Line.of(generateOneHeightOfLadder(participants.getNumberOfParticipants(), strategy)))
                .collect(Collectors.toList());

        return new Ladder(ladder);
    }

    private static List<Point> generateOneHeightOfLadder(int numberOfParticipants, LadderGeneratorStrategy strategy) {
        List<Point> points = new ArrayList<>();
        boolean beforePoint = false;
        boolean currentPoint = false;

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            currentPoint = isPossibleToConnected(beforePoint, strategy);
            points.add(Point.of(beforePoint, currentPoint));
            beforePoint = currentPoint;
        }

        points.add(Point.of(currentPoint, false));
        return points;
    }

    private static boolean isPossibleToConnected(boolean beforePoint, LadderGeneratorStrategy strategy) {
        if (beforePoint) {
            return false;
        }

        return strategy.generate();
    }
}
