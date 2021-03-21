package laddarGame.domain;

import laddarGame.dto.PlayerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayerTest {

    @DisplayName("이름의 길이는 최대 5글자 이다.")
    @Test
    void position() {
        assertThatThrownBy(
                () -> new Player("SISTER", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Player 정보를 PlayerDto로 반환한다.")
    @Test
    void createDto() {
        Player player = new Player("LG", 0);

        PlayerDto playerDto = player.playerDto();

        assertThat(playerDto).isEqualTo(new PlayerDto("LG", 0));
    }
}