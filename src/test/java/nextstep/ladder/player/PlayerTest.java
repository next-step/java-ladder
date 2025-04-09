package nextstep.ladder.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    void testPersonCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void testPersonCreationWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Player("abcdef"));
    }
}
