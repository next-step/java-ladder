package ladder.domain.line;

import ladder.domain.point.Direction;
import ladder.domain.point.LadderPoint;
import ladder.exception.OutOfSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLineBuilder {
    private final List<Direction> directions;

    LadderLineBuilder() {
        this.directions = new ArrayList<>();
    }

    public Manuel manuel() {
        return new Manuel();
    }

    public Auto auto(DirectionCreateStrategy directionCreateStrategy) {
        return new Auto(directionCreateStrategy);
    }

    private LadderLine finalBuild() {
        return IntStream.range(0, directions.size())
                .mapToObj(index ->
                        new LadderPoint(index, directions.get(index))
                )
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(), LadderLine::new
                        )
                );
    }

    public class Manuel {
        private Manuel() {}

        public Manuel next(Direction direction) {
            directions.add(direction);

            return this;
        }

        public LadderLine build() {
            return finalBuild();
        }
    }

    public class Auto {
        private static final int MIN_POINT_SIZE = 2;

        private final DirectionCreateStrategy directionCreateStrategy;

        private int pointSize;

        private Auto(DirectionCreateStrategy directionCreateStrategy) {
            this.directionCreateStrategy = directionCreateStrategy;
        }

        public Auto pointSize(int pointSize) {
            this.pointSize = pointSize;

            return this;
        }

        private void addFirstMiddlePoints() {
            List<Direction> newPoints =
                    Stream.iterate(directionCreateStrategy.first(), directionCreateStrategy::next)
                            .limit(pointSize - 1)
                            .collect(Collectors.toList());

            directions.addAll(newPoints);
        }

        private void addLastPoints() {
            directions.add(
                    directionCreateStrategy.last(
                            directions.get(directions.size() - 1)
                    )
            );
        }

        public LadderLine build() {
            validatePointSize();

            addFirstMiddlePoints();
            addLastPoints();

            return finalBuild();
        }

        private void validatePointSize() {
            if (pointSize < MIN_POINT_SIZE) {
                throw new OutOfSizeException("Point의 Size는 " + MIN_POINT_SIZE + " 이상 이어야 합니다.");
            }
        }
    }
}
