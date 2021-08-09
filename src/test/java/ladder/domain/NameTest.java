package ladder.domain;

import ladder.exception.OutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {
    @ValueSource(strings = {
            "AAAA", "BBBB", "DDDD", "EEEE"
    })
    @ParameterizedTest
    @DisplayName("5자 이하 정상 생성")
    void ctorTest(String name) {
        assertThatCode(() -> new Name(name))
                .doesNotThrowAnyException();
    }

    @ValueSource(strings = {
            "AAAAAA", "BBBBBB", "DDDDDD", "EEEEEE"
    })
    @ParameterizedTest
    @DisplayName("6자 이상 생성 실패")
    void ctorTest_OutOfSize(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(OutOfSizeException.class);
    }
}