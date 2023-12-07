package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    @DisplayName("Point는 주어진 가로 라인이 겹치는 경우 예외를 던진다")
    void newObject_twoLinesAttached_throwsException() {
        assertThatThrownBy(
                () -> new Point(true, true)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
