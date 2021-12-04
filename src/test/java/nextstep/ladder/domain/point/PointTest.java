package nextstep.ladder.domain.point;

import nextstep.ladder.domain.rule.RandomWayRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 Point의 index는 0이다")
    @Test
    void first() {
        Point firstPoint = Point.first(new RandomWayRule());
        assertThat(firstPoint.stay()).isZero();
    }

    @DisplayName("next: index가 1 증가한다.")
    @Test
    void next() {
        Point first = Point.first(() -> false);
        Point next = first.next(() -> true);
        assertThat(next.stay()).isOne();
    }

    @Test
    void equals() {
        assertThat(Point.first(() -> true)).isEqualTo(Point.first(() -> true));
    }

    @DisplayName("move: 제자리, 왼쪽, 오른쪽")
    @ParameterizedTest(name = "[{index}] index:1, left:{0}, right: {1}, movedIndex: {2}")
    @CsvSource({
            "false, false, 1",
            "true, false, 0",
            "false, true, 2"
    })
    void move_stayOrLeftOrRight(boolean left, boolean right, int movedIndex) {
        Point first = Point.first(() -> left);
        Point target = first.next(() -> right);

        assertThat(target.move()).isEqualTo(movedIndex);
    }

}
