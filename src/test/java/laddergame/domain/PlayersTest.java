package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @DisplayName("사다리 게임의 플레이어는 최소 2명이상이어야 한다")
    @Test
    void limitPlayerCount(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(List.of(new Player("name", 0))))
                .withMessage("사다리 게임의 플레이어는 최소 2명 이상이어야 합니다");
    }

    @DisplayName("플레이어의 수를 알 수 있다")
    @Test
    void size(){
        Players players = new Players(List.of(
                new Player("이름1", 0),
                new Player("이름2", 1))
        );

        assertThat(players.size()).isEqualTo(2);
    }

    @DisplayName("플레이어들의 위치는 0부터 1씩 순차적으로 증가해야 한다")
    @Test
    void checkPosition(){
        List<Player> players = List.of(
                new Player("name1", 2),
                new Player("name2", 1),
                new Player("name3", 0)
        );

        assertThatIllegalStateException()
                .isThrownBy(() -> new Players(players))
                .withMessage("플레이어의 위치가 0부터 순차적으로 증가하지 않았습니다");
    }

    @DisplayName("가장 처음에 위치한 플레이어의 위치를 구한다")
    @Test
    void firstPosition(){
        List<Player> playerGroup = List.of(
                new Player("name1", 0),
                new Player("name2", 1),
                new Player("name3", 2)
        );
        Players players = new Players(playerGroup);

        assertThat(players.firstPosition()).isEqualTo(0);
    }

    @DisplayName("가장 마지막에 위치한 플레이어의 위치를 구한다")
    @Test
    void lastPosition(){
        List<Player> playerGroup = List.of(
                new Player("name1", 0),
                new Player("name2", 1),
                new Player("name3", 2)
        );
        Players players = new Players(playerGroup);

        assertThat(players.lastPosition()).isEqualTo(2);
    }

    @DisplayName("같은 위치에 있는 플레이어를 조회한다")
    @Test
    void findBy(){
        List<Player> playerGroup = List.of(
                new Player("name1", 0),
                new Player("name2", 1)
        );
        Players players = new Players(playerGroup);

        assertThat(players.findBy(1)).isEqualTo(new Player("name2", 1));
    }

}