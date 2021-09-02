package ladderrefactoring.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫 번째 Point 생성")
    void first(){
        // when
        Point point = Point.first(() -> false);
        // then
        assertThat(point).isEqualTo(Point.first(() -> false));
    }

    @Test
    @DisplayName("중간 Point 생성")
    void create() {
        // when
        Point point1 = Point.first(() -> false);
        Point point2 = Point.of(point1, () -> false);
        // then
        assertThat(point2).isEqualTo(Point.of(point1, () -> false));
    }

    @Test
    @DisplayName("마지막 Point 생성")
    void last(){
        // when
        Point pointFirst = Point.first(() -> true);
        Point pointLast = Point.last(pointFirst);
        // then
        assertThat(pointLast).isEqualTo(Point.of(pointFirst, () -> false));
    }

    @ParameterizedTest(name = "Point 이동 [{index}] {0} {1} {2} -> {3}")
    @CsvSource({"false, false, 1", "true, false, 0", "false, true, 2"})
    void move(boolean left, boolean right, int result) {
        // when
        Point point0 = Point.first(() -> left);
        Point point1 = Point.of(point0, () -> right);
        // then
        assertThat(point1.move()).isEqualTo(result);
    }

}