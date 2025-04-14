package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Players.of(new String[0]));
    }
}
