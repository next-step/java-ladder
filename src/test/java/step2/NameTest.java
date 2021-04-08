package step2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import step2.domain.Name;

public class NameTest {

    @Test
    void length() {
        assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("abcdef");
        });
    }
}
