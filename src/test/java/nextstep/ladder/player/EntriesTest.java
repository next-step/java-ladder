package nextstep.ladder.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntriesTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Entries.of(new String[0]));
    }
}
