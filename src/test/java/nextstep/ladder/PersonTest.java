package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void testPersonCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null));
        assertThrows(IllegalArgumentException.class, () -> new Person(""));
    }

    @Test
    void testPersonCreationWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("abcdef"));
    }
}
