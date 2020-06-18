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

public class DrawingLadderLineStrategyTest {

    @DisplayName("Drawing 전략으로 Line을 그리면 그 너비는 게임 참가자의 수와 동일")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    public void lineLength_참가자수_동일(int playerCounts) {
        DrawingLineStrategy drawingLineStrategy = new RandomDrawingLineStrategy();

        List<Point> points = drawingLineStrategy.drawLine(playerCounts);

        assertThat(points.size()).isEqualTo(playerCounts);
    }

    @DisplayName("항상 오른쪽을 향하는 Point로 Line을 그리는 전략")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    public void drawingLine_항상_오른쪽(int countsOfPerson) {
        DrawingLineStrategy rightDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(0, Direction.RIGHT))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        boolean isRightDrawingLineValid = rightDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getDirection() == Direction.RIGHT);

        assertThat(isRightDrawingLineValid).isEqualTo(true);
    }

    @DisplayName("항상 왼쪽만 그리는 전략으로 Line을 그림")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    public void drawingLine_항상_왼쪽(int countsOfPerson) {
        DrawingLineStrategy leftDrawingStrategy = (playerCounts) -> {
            return Stream.generate(() -> new Point(0, Direction.LEFT))
                    .limit(playerCounts)
                    .collect(Collectors.toList());
        };

        boolean isLeftDrawingLineValid = leftDrawingStrategy.drawLine(countsOfPerson)
                .stream()
                .allMatch(point -> point.getDirection() == Direction.LEFT);

        assertThat(isLeftDrawingLineValid).isEqualTo(true);
    }
}
