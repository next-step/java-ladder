package ladder.domain.ladder;

import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.StairGenerationStrategy;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private static final int FIRST_INDEX = 0;

    private final List<RowPillars> rowPillars;

    private Ladder(final List<RowPillars> rowPillars) {
        validatePillars(rowPillars);
        this.rowPillars = rowPillars;
    }

    private void validatePillars(final List<RowPillars> rowPillars) {
        if (Objects.isNull(rowPillars) || rowPillars.size() < Height.MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public static Ladder of(final LadderShapeInfo ladderShapeInfo, final StairGenerationStrategy strategy) {
        return new Ladder(createPillars(ladderShapeInfo, strategy));
    }

    private static List<RowPillars> createPillars(final LadderShapeInfo ladderShapeInfo, final StairGenerationStrategy strategy) {
        return Stream.generate(() -> RowPillars.of(ladderShapeInfo.getWidth(), strategy))
                .limit(ladderShapeInfo.getHeight())
                .collect(Collectors.toList());
    }

    public List<RowPillars> getRowPillars() {
        return rowPillars;
    }

    public Positions ride() {
        return Positions.of(
                IntStream.range(FIRST_INDEX, getLadderWidth())
                        .mapToObj(Position::of)
                        .map(this::rideOnePlayer)
                        .collect(Collectors.toList())
        );
    }

    private Position rideOnePlayer(final Position playerPosition) {
        return rowPillars.stream()
                .reduce(playerPosition, (byPosition, rowPillar) -> rowPillar.nextPosition(byPosition),
                        (x, y) -> {throw new RuntimeException(ErrorMessage.NOT_ALLOW_REDUCE_IN_PARALLEL_ENV);});
    }

    private int getLadderWidth() {
        return rowPillars.get(FIRST_INDEX).getWidth();
    }
}
