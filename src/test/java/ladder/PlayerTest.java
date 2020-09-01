package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1,2,3,4,5,6,7,8,9,10"})
    public void playerIndexTest(String names) {

        Player player = new Player(names);

        for (int i = 0; i < player.getNames().size(); i++) {
            assertEquals(player.getPlayerIndex(player.getNames().get(i)), i);
        }
    }
}
