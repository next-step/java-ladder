package ladderrefactoring.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @BeforeEach
    void init() {
        Direction.directionStrategy = () -> false;
    }

    @Test
    @DisplayName("첫 번째 Point 생성")
    void first(){
        // when
        Point point = Point.first();
        // then
        assertThat(point).isEqualTo(Point.first());
    }

    @Test
    @DisplayName("중간 Point 생성")
    void create() {
        // when
        Point point = Point.first().next();
        // then
        assertThat(point).isEqualTo(Point.of(1, Direction.of(false, false)));
    }

    @Test
    @DisplayName("마지막 Point 생성")
    void last(){
        // when
        Point pointLast = Point.first().last();
        // then
        assertThat(pointLast).isEqualTo(Point.of(1, Direction.of(false, false)));
    }

    @ParameterizedTest(name = "Point 이동 [{index}] {0} {1} {2} -> {3}")
    @CsvSource({"false, false, 1", "true, false, 0", "false, true, 2"})
    void move(boolean left, boolean right, int result) {
        // when
        Point point = Point.of(1, Direction.of(left, right));
        // then
        assertThat(point.move()).isEqualTo(result);
    }
}