package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    
    @Test
    @DisplayName("이름 목록을 입력받아 플레이어 객체들을 생성한다.")
    public void create() throws Exception {
        //given
        Players players = new Players("pobi", "dobi");
        List<Player> allPlayers = players.allPlayers();

        //when
        int size = allPlayers.size();

        //then
        assertThat(size).isEqualTo(2);
    }
}
