package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @ParameterizedTest
    @EmptySource
    @DisplayName("PersonNames 은 아무런 이름이 주어지지 않으면 예외를 던진다.")
    void newObject_empty_throwsException(String[] empty) {
        assertThatThrownBy(
                () -> new Players(empty)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
