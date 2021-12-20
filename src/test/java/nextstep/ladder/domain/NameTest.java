package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author han
 */
class NameTest {

    @ParameterizedTest
    @DisplayName("생성")
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    void create(String name) {
        assertThat(Name.of(name).getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("이름 길이 초과 예외처리")
    @ValueSource(strings = {"aaaaaaaaaaa", "bbbbbbbbbbbbbbb"})
    void throwExceptionIfNameSizeOver(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Name.of(name));
    }

    @ParameterizedTest
    @DisplayName("null or empty 입력시 예외처리")
    @NullAndEmptySource
    void throwExceptionNullOrEmpty(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Name.of(name));
    }
}