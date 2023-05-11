package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @Test
    void 이름_길이() {
        assertThat(Name.of("abcd").length()).isEqualTo(4);
    }

    @Test
    void 이름_널() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Name.of(null))
            .withMessageMatching("이름은 빈값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 이름_빈값(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Name.of(input))
            .withMessageMatching("이름은 빈값일 수 없습니다.");
    }

    @Test
    void 이름생성() {
        assertThat(Name.of("abced")).isEqualTo(Name.of("abced"));
    }

}
