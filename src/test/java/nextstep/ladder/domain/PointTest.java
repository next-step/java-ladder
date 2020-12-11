package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("첫 인덱스일 경우, 왼쪽 방향일 때 예외처리")
    void firstIndexNotLeft() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Point.from(0, Direction.LEFT));
    }

}