package ladder;

import ladder.domain.Player;
import ladder.domain.PlayerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerListTest {

    @Test
    @DisplayName("플레이어 생성 테스트")
    void create() {
        String[] names = {"pobi","test"};

        PlayerList playerList = PlayerList.of(names);

        assertThat(playerList.size()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("플레이어 이름으로 정상적으로 찾느지 테스트")
    void player() {
        Player pobi = new Player("pobi",0);
        Player test = new Player("test",1);
        List<Player> players = Arrays.asList(pobi, test);

        PlayerList playerList = new PlayerList(players);

        assertThat(playerList.player(pobi.name())).isEqualTo(pobi);
    }
}
