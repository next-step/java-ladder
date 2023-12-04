package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BraceTest {
    @Test
    @DisplayName("Brace는 주어진 가로 라인이 겹치는 경우 예외를 던진다")
    void newObject_twoLinesAttached_throwsException() {
        assertThatThrownBy(
                () -> new Brace(Point.TRUE,Point.TRUE)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
