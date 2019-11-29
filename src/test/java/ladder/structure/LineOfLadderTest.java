package ladder.structure;

import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.result.Point;
import ladder.structure.connection.result.Points;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineOfLadderTest {
    @Test
    @DisplayName("각 줄 별 점의 이동 확인")
    void getPointsAfterConnectionTest() {
        LineOfLadder defaultConnection = new LineOfLadder(5, new DefaultConnection());
        Points first = defaultConnection.getPoints();
        assertThat(first.getPoints())
                .containsExactly(Point.of(0), Point.of(1), Point.of(2), Point.of(3), Point.of(4));

        defaultConnection = defaultConnection.getNext(new DefaultConnection());
        Points second = defaultConnection.getPoints();
        assertThat(second.getPoints())
                .containsExactly(Point.of(1), Point.of(0), Point.of(3), Point.of(2), Point.of(4));
    }
}