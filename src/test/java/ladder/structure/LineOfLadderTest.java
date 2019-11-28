package ladder.structure;

import ladder.game.Point;
import ladder.game.Points;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.NoneConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineOfLadderTest {
    @Test
    @DisplayName("각 줄 별 점의 이동 확인")
    void getPointsAfterConnectionTest() {
        LineOfLadder noneConnectionLine = new LineOfLadder(4, new NoneConnection());
        Points first = noneConnectionLine.getPointsAfterConnection(null);
        assertThat(first.getPoints())
                .containsExactly(Point.of(0), Point.of(1), Point.of(2), Point.of(3), Point.of(4));

        LineOfLadder defaultConnectionLine = new LineOfLadder(4, new DefaultConnection());
        Points second = defaultConnectionLine.getPointsAfterConnection(first);
        assertThat(second.getPoints())
                .containsExactly(Point.of(1), Point.of(0), Point.of(3), Point.of(2), Point.of(4));
    }
}