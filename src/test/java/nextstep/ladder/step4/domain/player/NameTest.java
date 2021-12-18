package nextstep.ladder.step4.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step4.exception.ArgumentNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    @DisplayName("생성 성공")
    void create(String name) {
        assertThat(new Name(name)).isInstanceOf(Name.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 값일 경우")
    void nullException(String name) {
        assertThatExceptionOfType(ArgumentNullPointerException.class)
            .isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"donghyo", "kimdonghyo", "123456"})
    @DisplayName("null 혹은 빈 값일 경우")
    void sizeException(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(name));
    }

}
