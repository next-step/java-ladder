package ladder.player.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("참여자는 2명 이상이어야 한다")
    @Test
    public void playersMoreThanEqualTwoTest() {
        assertThatThrownBy(() -> Players.of("이정원"))
                .isInstanceOf(NotEnoughCountOfPersonException.class)
                .hasMessageContaining("사다리 게임을 하려면 최소 2명 이상이어야 합니다.");
    }

    @DisplayName("참여자의 수를 알 수 있다.")
    @Test
    public void countOfPlayersTest() {
        Players players = Players.of("jwee0330", "jayden");

        assertThat(players.size()).isEqualTo(2);
    }

}
