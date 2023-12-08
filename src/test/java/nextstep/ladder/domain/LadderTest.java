package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    private static final Brace BRACE_LEFT = new Brace(true, false);
    private static final Brace BRACE_RIGHT = new Brace(false, true);
    private static final Brace BRACE_NONE = new Brace(false, false);

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Ladder 는 아무런 라인이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Line> lines) {
        assertThatThrownBy(
                () -> new Ladder(lines)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_success() {
        Line firstLine = new Line(List.of(BRACE_RIGHT, BRACE_LEFT, BRACE_NONE, BRACE_NONE));
        assertThat(firstLine.move(0)).isEqualTo(1);
        assertThat(firstLine.move(1)).isEqualTo(0);
        assertThat(firstLine.move(2)).isEqualTo(2);
        assertThat(firstLine.move(3)).isEqualTo(3);
    }
}
