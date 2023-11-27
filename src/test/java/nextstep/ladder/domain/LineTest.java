package nextstep.ladder.domain;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("Line은 주어진 가로 라인이 겹치는 경우 예외를 던진다")
    void newObject_twoLinesAttached_throwsException() {
        List<Boolean> list = List.of(false, true, true);
        assertThatThrownBy(
                () -> new Line(list)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
