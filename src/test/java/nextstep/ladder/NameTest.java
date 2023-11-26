package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Name 은 아무런 이름이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(String nullAndEmpty) {
        assertThatThrownBy(
                () -> new Name(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Name 은 유효한 범위 내의 길이가 아닌 경우 예외를 던진다.")
    void newObject_lessThanMinLengthOrMoreThanMaxLength_throwsException() {
        assertThatThrownBy(
                () -> new Name("abcdef")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
