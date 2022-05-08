package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class PlayerNameTest {

    @Test
    @DisplayName("참여자의 이름 생성")
    void create() {
        assertThat(PlayerName.from("abc")).isEqualTo(PlayerName.from("abc"));
    }

    @DisplayName("참여자의 이름은 null 혹은 공백일 수 없습니다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyException(String playerName) {
        assertThatThrownBy(() -> PlayerName.from(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자의 이름은 최대 5자입니다. 그 이상은 예외를 발생합니다.")
    void tooLongPlayerName() {
        assertThatThrownBy(() -> PlayerName.from("tooLongPlayerName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}