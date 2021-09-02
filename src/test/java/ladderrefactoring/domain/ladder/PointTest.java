package ladderrefactoring.domain.ladder;
import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    @DisplayName("첫 번째 Point 생성")
    void first(){
        // when
        Point point = Point.first(false);
        // then
        assertThat(point).isEqualTo(Point.of(0, false, false));
    }

    @Test
    @DisplayName("마지막 Point 생성")
    void last(){
        // when
        Point pointFirst = Point.first(true);
        Point pointLast = Point.last(pointFirst);
        // then
        assertThat(pointLast).isEqualTo(Point.of(1, true, false));
    }

    @Test
    @DisplayName("Point 생성")
    void create() {
        // when
        Point point = Point.of(2, false, false);
        // then
        assertThat(point).isEqualTo(Point.of(2, false, false));
    }

    @Test
    @DisplayName("이전의 Point 와 연관된 Point 생성")
    void create_with_before_point(){
        // when
        Point point0 = Point.first(false);
        Point point1 = Point.of(point0, false);

        // then
        assertThat(point1).isEqualTo(Point.of(1, false, false));
    }

    @Test
    @DisplayName("Point 생성 실패 : true, true")
    void create_fail() {
        // when, then
        assertThatThrownBy(() -> Point.of(2, true, true))
                .isInstanceOf(CustomException.class);
    }

    @ParameterizedTest(name = "Point 이동 [{index}] {0} {1} {2} -> {3}")
    @CsvSource({"2, false, false, 2", "2, true, false, 1", "2, false, true, 3"})
    void move(int index, boolean left, boolean right, int result) {
        // when
        Point point = Point.of(index, left, right);
        // then
        assertThat(point.move()).isEqualTo(result);
    }

}