package ladder.domain.ladder.generator;

import ladder.domain.ladder.*;
import ladder.domain.member.MemberGroup;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final DirectionGenerator directionGenerator;


    public LadderGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator= directionGenerator;
    }

    public Ladder generateLadder(MemberGroup memberGroup, int height) {
        validateLadderHeight(height);

        return new Ladder(generateLines(memberGroup, height));
    }

    Lines generateLines(MemberGroup memberGroup, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.init(memberGroup.getNumberOfMembers(), directionGenerator))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("Height of ladder must be at least " + MIN_LADDER_HEIGHT);
        }
    }
}
