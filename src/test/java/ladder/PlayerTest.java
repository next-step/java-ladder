package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void playerIndexTest() {
        Player player = new Player("a,b,c");

        assertEquals(player.getPlayerIndex("a"), 0);
        assertEquals(player.getPlayerIndex("b"), 1);
        assertEquals(player.getPlayerIndex("c"), 2);
    }
}
