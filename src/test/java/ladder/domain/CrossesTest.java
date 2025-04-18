package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrossesTest {
    @Test
    @DisplayName("Point 리스트로 Crosses 를 생성할 수 있다")
    void fromTest() {
        List<Point> points = List.of(
                Point.first(true),
                Point.first(false).next(false),
                Point.first(false).next(false).next(true)
        );

        Crosses crosses = Crosses.from(points);

        assertThat(crosses).isNotNull();
        assertThat(crosses.getPoints()).hasSize(2);
    }

    @Test
    @DisplayName("getPoints는 마지막 Cross를 제외하고 current 값만 리스트로 반환한다")
    void getPointsTest_excludeLast() {
        List<Point> points = List.of(
                Point.first(true),
                Point.first(true).next(false),
                Point.first(true).next(false).next(true)
        );
        Crosses crosses = Crosses.from(points);

        List<Boolean> results = crosses.getPoints();

        assertThat(results).containsExactly(true, false);
    }

}
