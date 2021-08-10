package nextstep.ladder.player;

import nextstep.ladder.exception.IllegalPlayerNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어 이름은 5글자를 넘을 수 없다.")
    @Test
    void player_name_validation() {
        assertThatThrownBy(() -> Player.of("123456", 0))
                .isInstanceOf(IllegalPlayerNameSizeException.class);
    }

    @DisplayName("플레이어의 초기 position 값 확인 ")
    @Test
    void get_player_position() {
        Players players = Players.of("pobi,honux,crong,jk");
        List<Player> playerList = players.getPlayers();
        AtomicInteger index = new AtomicInteger(-1);

        playerList.forEach(p -> assertThat(p.getPosition()).isEqualTo(index.incrementAndGet()));

    }
}