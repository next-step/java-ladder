package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    @Test
    @DisplayName("첫 인덱스일 경우, 왼쪽 방향일 때 예외처리")
    void firstIndexNotLeft() {

        assertThrows(IllegalArgumentException.class,
                () -> Point.from(0, Direction.LEFT));
    }

    @Test
    @DisplayName("다음 인덱스 계산 후 반환")
    void getNextPoint() {
        Point point1 = Point.from(0, Direction.RIGHT);

        assertThat(point1.getNextPoint()).isEqualTo(1);
    }

}
