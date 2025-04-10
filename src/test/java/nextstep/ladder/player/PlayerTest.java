package nextstep.ladder.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void testPlayerCreationWithEmptyName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Player(name));
    }

    @Test
    void testPlayerCreationWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Player("abcdef"));
    }
}
