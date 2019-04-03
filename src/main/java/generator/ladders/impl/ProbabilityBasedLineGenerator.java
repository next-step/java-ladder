package generator.ladders.impl;

import domain.ladder.Ladder;
import domain.ladder.Ladders;
import generator.ladder.LadderGenerator;
import generator.ladders.LaddersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProbabilityBasedLineGenerator implements LaddersGenerator {

    private final LadderGenerator ladderGenerator;

    public ProbabilityBasedLineGenerator(int percentage) {
        this.ladderGenerator = new generator.ladder.impl.ProbabilityBasedLineGenerator(percentage);
    }

    @Override
    public Ladders generate(int height, int lineSize) {
        List<Ladder> ladders = IntStream.range(0, height)
                .mapToObj(i -> ladderGenerator.generate(lineSize))
                .collect(Collectors.toList());

        return new Ladders(ladders);
    }
}
