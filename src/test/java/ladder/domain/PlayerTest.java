package ladder.domain;

import ladder.exception.OutOfLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @ValueSource(strings = {
            "pobi",
            "honux",
            "crong",
            "jk"
    })
    @DisplayName("이름 5자 테스트 성공")
    @ParameterizedTest
    public void ctorTest(String name) {
        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }

    @ValueSource(strings = {
            "pobi12",
            "honux1",
            "crong1",
            "jk1234"
    })
    @DisplayName("이름 5자 초과 테스트")
    @ParameterizedTest
    public void ctorExceptionTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(OutOfLengthException.class);
    }
}