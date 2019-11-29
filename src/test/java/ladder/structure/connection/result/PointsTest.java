package ladder.structure.connection.result;

import ladder.structure.connection.DefaultConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    @DisplayName("point이동 경로 확인")
    void getPointsTest() {
        Points first = new Points(2, new DefaultConnection());

        Points second = first.getNext(new DefaultConnection());
        assertThat(second.getPoints())
                .containsExactly(Point.of(1), Point.of(0), Point.of(2));

        Points third = second.getNext(new DefaultConnection());
        assertThat(third.getPoints())
                .containsExactly(Point.of(0), Point.of(1), Point.of(2));
    }
}