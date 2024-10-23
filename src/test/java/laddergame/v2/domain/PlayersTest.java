package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @DisplayName("사다리 게임의 플레이어는 최소 2명이상이어야 한다")
    @Test
    void limitPlayerCount(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(List.of(new Player("name"))))
                .withMessage("사다리 게임의 플레이어는 최소 2명 이상이어야 합니다");
    }

    @DisplayName("플레이어의 수를 알 수 있다")
    @Test
    void size(){
        Players players = new Players(List.of(
                new Player("이름1"),
                new Player("이름2"))
        );

        assertThat(players.size()).isEqualTo(2);
    }
}
