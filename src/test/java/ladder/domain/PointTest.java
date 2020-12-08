package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("Point next() 사용하여 다음 상태값 예상")
    void point_next_isEqualTo() {
        // given
        Point point = Point.of(0,Pointer.of(false,true));
        Point actual = Point.next(point,() -> false);

        // when
        Point expect = Point.of(1,Pointer.of(true,false));

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("Point first() 사용 하여 첫번째 상태값 예상")
    void point_first_isEqualTo() {
        Point actual = Point.first(() -> true);
        assertThat(actual).isEqualTo(Point.of(0,Pointer.of(false,true)));
    }

    @Test
    @DisplayName("Point last() 사용 하여 마지막 상태값 예상")
    void point_last_isEqualTo() {
        Point actual = Point.last(Point.of(4,Pointer.of(true,false)));
        assertThat(actual).isEqualTo(Point.of(5,Pointer.of(false,false)));
    }
}
