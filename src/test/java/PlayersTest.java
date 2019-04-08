import domain.Player;
import domain.Players;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayersTest {

    @Test
    public void threePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("mario"));
        players.add(new Player("luige"));
        players.add(new Player("yoshi"));

        Players participants = new Players(players);
        assertEquals(3, participants.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPlayerName() {
        Player player = new Player("nextstep");
    }
}
