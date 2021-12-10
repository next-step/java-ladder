package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PlayerNameTest {

    @Test
    @DisplayName("선수 이름 생성")
    void create() {
        PlayerName name = new PlayerName("kang");
        assertThat(name).isEqualTo(new PlayerName("kang"));
    }

    @ParameterizedTest
    @DisplayName("0<이름<6 값이 아닐 경우 검증 -> IllegalArgumentException")
    @CsvSource(value = {"abcdef, "})
    void checkName(String input) {
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class);
        //정상
        assertThatCode(() -> new PlayerName("a"))
                .doesNotThrowAnyException();
        assertThatCode(() -> new PlayerName("abcde"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("0<이름<6 정상값 검증")
    @CsvSource(value = {"a, abcde"})
    void checkNameOK(String input) {
        assertThatCode(() -> new PlayerName(input))
                .doesNotThrowAnyException();
        assertThatCode(() -> new PlayerName(input))
                .doesNotThrowAnyException();
    }

}