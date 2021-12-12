package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.exception.InputNullPointerException;
import nextstep.ladder.exception.NameSizeOverBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    @DisplayName("생성 성공")
    void create(String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"donghyo", "kimhyo"})
    @DisplayName("이름 길이 초과 예외처리")
    void nameSizeOverBoundException(String name) {
        assertThatExceptionOfType(NameSizeOverBoundException.class)
            .isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 NULL 혹은 빈값 예외처리")
    void nameNullPointerException(String name) {
        assertThatExceptionOfType(InputNullPointerException.class)
            .isThrownBy(() -> new Name(name));
    }

}
