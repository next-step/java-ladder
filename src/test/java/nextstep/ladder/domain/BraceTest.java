package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BraceTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("Brace는 빈 라인이 주어지면 예외를 던진다.")
    void newObject_null_throwsException(Point point) {
        assertThatThrownBy(
                () -> new Brace(point)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
