package nextstep.ladder.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntriesTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Entries(new String[0]));
        assertThrows(IllegalArgumentException.class, () -> new Entries(List.of()));
    }
}
