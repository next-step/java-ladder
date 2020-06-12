package ladder;

import ladder.domain.Direction;
import ladder.domain.DrawingLineStrategy;
import ladder.domain.Point;
import ladder.domain.RandomDrawingLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawingLineStrategyTest {

    @DisplayName("Random전략으로 Line을 그리면 그 너비는 playerCounts - 1과 동일")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    public void lineLengthTest(int playerCounts) {
        DrawingLineStrategy drawingLineStrategy = new RandomDrawingLineStrategy();

        List<Point> points = drawingLineStrategy.drawLine(playerCounts);

        assertThat(points.size()).isEqualTo(playerCounts);
    }

    @DisplayName("다른 전략으로 Line 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    public void useOtherStrategy(int countsOfPerson) {
        DrawingLineStrategy rightDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(0, Direction.RIGHT))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        DrawingLineStrategy leftDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(0, Direction.LEFT))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        boolean isRightDrawingLineValid = rightDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getDirection() == Direction.RIGHT);

        boolean isLeftDrawingLineValid = leftDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getDirection() == Direction.LEFT);

        assertThat(isRightDrawingLineValid).isEqualTo(true);
        assertThat(isLeftDrawingLineValid).isEqualTo(true);
    }
}
