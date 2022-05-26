package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    private final DirectionGenerateStrategy generateStrategy;

    public LadderGenerator(DirectionGenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Ladder createLadder(Participants participants, int height) {
        return IntStream.range(0, height)
                .mapToObj((index) -> Line.of(getWidth(participants), generateStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), lines -> new Ladder(lines, participants)));
    }
    private static Integer getWidth(Participants participants) {
        return participants.getParticipants().size();
    }
}
