package ladder.domain.ladder.generator;

import ladder.domain.ladder.*;
import ladder.domain.member.MemberGroup;
import ladder.vo.Length;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private final DirectionGenerator directionGenerator;

    public LadderGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator= directionGenerator;
    }


    public Ladder2 generateLadder(MemberGroup memberGroup, Length height) {
        return new Ladder2(generateLines(memberGroup, height));
    }

    Lines2 generateLines(MemberGroup memberGroup, Length height) {
        List<Line2> lines = IntStream.range(0, height.getValue())
                .mapToObj(i -> Line2.init(memberGroup.getNumberOfMembers(), directionGenerator))
                .collect(Collectors.toList());

        return new Lines2(lines);
    }
}
