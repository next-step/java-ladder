package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Line은 은 아무런 Point가 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Brace> nullAndEmpty) {
        assertThatThrownBy(
                () -> new Line(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
