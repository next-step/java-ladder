package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름이 null이거나 비어있으면 예외가 발생한다.")
    void nameIsNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Name.of(null));
        assertThrows(IllegalArgumentException.class, () -> Name.of(""));
    }

    @Test
    @DisplayName("이름이 5자 이상이면 예외가 발생한다.")
    void nameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> Name.of("abcdef"));
    }
}
