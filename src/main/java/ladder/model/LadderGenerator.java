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

    private static List<Boolean> generateOneHeightOfLadder(int numberOfParticipants, LadderGeneratorStrategy strategy) {
        List<Boolean> points = new ArrayList<>();
        boolean isConnectedHorizontally = false;

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            isConnectedHorizontally = isPossibleToConnected(isConnectedHorizontally, strategy);
            points.add(isConnectedHorizontally);
        }

        points.add(false);
        return points;
    }

    private static boolean isPossibleToConnected(boolean isConnectedHorizontally, LadderGeneratorStrategy strategy) {
        if (isConnectedHorizontally) {
            return false;
        }

        return strategy.generate();
    }
}
