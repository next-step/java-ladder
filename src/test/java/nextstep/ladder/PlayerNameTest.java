package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class PlayerNameTest {

    @Test
    @DisplayName("플레이어의 이름 객체 생성")
    void create() {
        PlayerName playerName = new PlayerName("wang");
        assertThat(playerName).isEqualTo(new PlayerName("wang"));
    }

    @Test
    @DisplayName("플레이어의 이름이 5자를 초과하면 예외 발생")
    void invalidPlayerName() {
        assertThatThrownBy(() -> new PlayerName("WangTak"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어의 이름이 null 혹은 빈 문자열일 경우 예외 발생")
    void nullOrEmptyPlayerName(String playerName) {
        assertThatThrownBy(() -> new PlayerName(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
