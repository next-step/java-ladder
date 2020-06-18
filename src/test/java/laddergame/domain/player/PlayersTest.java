package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("Player 리스트로 만들 String 배열이 Null 또는 길이가 0 이면 IllegalArgumentException throw")
    @Test
    void validateCreatePlayers() {
        assertAll(
                () -> assertThatThrownBy(() -> new Players(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력한 이름들이 Null 또는 빈 배열입니다."),
                () -> assertThatThrownBy(() -> new Players(new String[0]))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력한 이름들이 Null 또는 빈 배열입니다.")
        );

    }
}