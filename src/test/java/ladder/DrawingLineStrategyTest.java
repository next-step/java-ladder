package ladder;

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
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void lineLengthTest(int playerCounts) {
        DrawingLineStrategy drawingLineStrategy = new RandomDrawingLineStrategy();

        List<Point> points = drawingLineStrategy.drawLine(playerCounts);

        assertThat(points.size()).isEqualTo(playerCounts - 1);
    }

    @DisplayName("다른 전략으로 Line 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    public void useOtherStrategy(int countsOfPerson) {
        DrawingLineStrategy alwaysDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(true))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        DrawingLineStrategy alwaysNotDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(false))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        boolean isAlwaysDrawingLineValid = alwaysDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getIsExisting() == true);

        boolean isAlwaysNotDrawingLineValid = alwaysNotDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getIsExisting() == false);

        assertThat(isAlwaysDrawingLineValid).isEqualTo(true);
        assertThat(isAlwaysNotDrawingLineValid).isEqualTo(true);
    }
}
