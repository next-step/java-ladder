package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesGenerator {

    private final BridgesGenerator bridgesGenerator = new SequentialRandomBridgesGenerator();

    public List<Line> generatorLines(Integer numbersOfPeople, Integer height) {
        return IntStream.range(0, height)
                .mapToObj(index -> new Line(numbersOfPeople, bridgesGenerator.generateBridges(numbersOfPeople)))
                .collect(Collectors.toList());
    }
}
