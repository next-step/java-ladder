package nextstep.ladder.domain;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("Line은 주어진 가로 라인이 겹치는 경우 예외를 던진다")
    void newObject_twoLinesAttached_throwsException() {
        List<Point> list = List.of(new Point(false), new Point(true), new Point(true));
        assertThatThrownBy(
                () -> new Line(list)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Line은 은 아무런 Point가 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Point> nullAndEmpty) {
        assertThatThrownBy(
                () -> new Line(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
