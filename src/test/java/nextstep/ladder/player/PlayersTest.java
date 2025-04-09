package nextstep.ladder.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Players(new String[0]));
        assertThrows(IllegalArgumentException.class, () -> new Players(List.of()));
    }
}
