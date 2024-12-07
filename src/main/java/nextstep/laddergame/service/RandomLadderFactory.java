package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderFactory extends LadderFactory {
    @Override
    public Ladder createLadder(int ladderCount, int maxHeight, LineGenerator lineGenerator) {
        List<Line> lines = IntStream.range(0, maxHeight)
                .mapToObj(index ->
                        lineGenerator.generate(ladderCount)
                ).collect(Collectors.toList());
        return new Ladder(lines);
    }
}
