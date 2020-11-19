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
    public static final String ERROR_INVALID_LADDER_HEIGHT = "사다리 높이는 0보다 커야 합니다.";

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(LadderBuildDTO buildDTO, MakeLineStrategy strategy) {
        isValidLineHeight(buildDTO.getLineHeight());

        return IntStream.range(0, buildDTO.getLineHeight())
                .mapToObj(index -> Line.of(buildDTO.getPlayers().count(), strategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public boolean isExistsPoint(Point point) {
        Line line = Optional.ofNullable(ladder.get(point.getY())).orElseThrow(NoSuchElementException::new);
        return line.isExistsPoint(point);
    }

    public void forEach(Consumer<Line> function) {
        ladder.forEach(function);
    }

    public static void isValidLineHeight(int lineHeight) {
        if (lineHeight <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_LADDER_HEIGHT);
        }
    }
}
