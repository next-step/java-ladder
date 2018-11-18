package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    public void 생성확인() {
        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        Players playres = new Players(player);

        assertThat(playres.getPlayers().get(0)).isEqualTo(new Player("pobi"));
        assertThat(playres.getPlayers().get(1)).isEqualTo(new Player("crox"));
    }
}
