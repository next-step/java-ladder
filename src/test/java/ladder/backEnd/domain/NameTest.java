package ladder.backEnd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    @DisplayName("이름 5자 이상 => Error")
    void over_5_letter() {
        assertThrows(IllegalArgumentException.class,
                () -> new Name("jiooooo"));
    }

}
