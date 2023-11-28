package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonNamesTest {
    @ParameterizedTest
    @EmptySource
    @DisplayName("PersonNames 은 아무런 이름이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(String empty) {
        assertThatThrownBy(
                () -> new PersonNames(empty)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
