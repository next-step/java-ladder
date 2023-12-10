package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesGenerator {

    private static final Integer MIN_HEIGHT = 1;

    private final BridgesGenerator bridgesGenerator = new SequentialRandomBridgesGenerator();

    public List<Line> generatorLines(Integer numbersOfPeople, Integer height) {
        validateHeight(height);
        return IntStream.range(0, height)
                .mapToObj(index -> new Line(numbersOfPeople, bridgesGenerator.generateBridges(numbersOfPeople)))
                .collect(Collectors.toList());
    }

    private void validateHeight(Integer height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 최소 1 이상이어야 합니다.");
        }
    }
}
