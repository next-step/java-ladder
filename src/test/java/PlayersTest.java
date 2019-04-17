import domain.Player;
import domain.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PlayersTest {
    List<Player> players = new ArrayList<>();
    Players participants;
    Player yoshi;

    @Before
    public void setUp() throws Exception {
        players.add(new Player("mario"));
        players.add(new Player("luige"));

        yoshi = new Player("yoshi");
        players.add(yoshi);

        participants = new Players(players);
    }

    @Test
    public void threePlayers() {
        assertEquals(3, participants.getNumber());
    }

    @Test
    public void find() {
        assertThat(participants.find("yoshi").equals(yoshi)).isTrue();
    }
}
