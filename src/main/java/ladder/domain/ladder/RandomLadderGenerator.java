package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public RandomLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(int ladderHeight, int countOfPerson) {
        List<Line> lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> lineGenerator.generate(countOfPerson))
                .collect(Collectors.toList());
        return Ladder.of(lines);
    }
}
