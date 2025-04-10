package nextstep.ladder.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryTest {

    @ParameterizedTest
    @NullAndEmptySource
    void testEntryCreationWithEmptyName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Entry(name));
    }

    @Test
    void testEntryCreationWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Entry("abcdef"));
    }
}
