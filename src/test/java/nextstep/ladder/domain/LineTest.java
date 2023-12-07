package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    private static final Point POINT_LEFT = new Point(true, false);
    private static final Point POINT_RIGHT = new Point(false, true);
    private static final Point POINT_NONE = new Point(false, false);

    private static final Brace BRACE_LEFT = new Brace(POINT_LEFT);
    private static final Brace BRACE_RIGHT = new Brace(POINT_RIGHT);
    private static final Brace BRACE_NONE = new Brace(POINT_NONE);

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Line은 아무런 Point가 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Brace> nullAndEmpty) {
        assertThatThrownBy(
                () -> new Line(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line은 가로 선이 연결되어 있지 않으면 예외를 던진다.")
    void newObject_notConnected_throwsException() {
        List<Brace> braces = List.of(BRACE_RIGHT, BRACE_RIGHT);

        assertThatThrownBy(
                () -> new Line(braces)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
