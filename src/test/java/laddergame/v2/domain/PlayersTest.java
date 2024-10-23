package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        Players players = createPlayer("이름1", "이름");

        assertThat(players.size()).isEqualTo(2);
    }

    @DisplayName("사다리 시작 위치로 플레이어를 조회한다")
    @Test
    void get(){
        Player name1 = new Player("name1");
        Player name2 = new Player("name2");
        Players players = new Players(List.of(name1, name2));

        assertThat(players.get(0)).isEqualTo(name1);
        assertThat(players.get(1)).isEqualTo(name2);
    }
    
    @DisplayName("이름으로 플레이어 조회한다")
    @Test
    void findBy(){
        Player name1 = new Player("name1");
        Player name2 = new Player("name2");
        Players players = new Players(List.of(name1, name2));

        players.findBy("name1").get();
        assertThat(players.findBy("name1").get()).isEqualTo(name1);
    }

    private Players createPlayer(String... names){
        List<Player> players = new ArrayList<>();
        for(String name : names){
            players.add(new Player(name));
        }
        return new Players(players);

    }
}
