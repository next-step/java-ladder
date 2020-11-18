package step2.domain.ladder;

import step2.domain.ladder.dto.LadderBuildDTO;
import step2.strategy.MakeLineStrategy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(LadderBuildDTO buildDTO, MakeLineStrategy strategy) {
        ladder = buildLadder(buildDTO, strategy);
    }

    private List<Line> buildLadder(LadderBuildDTO buildDTO, MakeLineStrategy strategy) {
        return IntStream.range(0, buildDTO.getLineHeight())
                .mapToObj(index -> new Line(buildDTO.getPlayers().count(), strategy))
                .collect(Collectors.toList());
    }

    public boolean isExistsPoint(Point point) {
        Line line = Optional.ofNullable(ladder.get(point.getY())).orElseThrow(NoSuchElementException::new);
        return line.isExistsPoint(point);
    }

    public void forEach(Consumer<Line> function) {
        ladder.forEach(function);
    }
}
