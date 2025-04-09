package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonsTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Persons(new String[0]));
        assertThrows(IllegalArgumentException.class, () -> new Persons(List.of()));
    }
}
