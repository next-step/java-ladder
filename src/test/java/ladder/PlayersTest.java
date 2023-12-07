package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayersTest {

    @Test
    public void 플레이어_리스트_생성(){

        List<Player> list = new ArrayList<>();

        list.add(new Player("test1"));
        list.add(new Player("test2"));
        list.add(new Player("test3"));

        Players players = new Players(list);

        Assertions.assertThat(players.getPlayers().contains(new Player("test1"))).isTrue();

    }
}
