package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("5명의 플레이어를 등록한다.")
    void players_add_test() {
        String names = "a,b,c,d,e";
        int expected = 5;

        Players players = new Players(names);

        assertThat(players.numberOfPlayers()).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어가 1명인 경우 예외가 발생한다.")
    void player_exception_test() {
        String names = "a";
        assertThatThrownBy(() ->
                new Players(names)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}