package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ValueSource(strings = {"abcdef", ""})
    void checkNameFail(String input) {
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름이 null 검증 -> NullPointerException")
    @NullSource
    void checkNameNull(String input) {
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @DisplayName("1<=이름<=6 정상값 검증")
    @ValueSource(strings = {"a", "abcde"})
    void checkNameOK(String input) {
        assertThatCode(() -> new PlayerName(input))
                .doesNotThrowAnyException();
    }

}