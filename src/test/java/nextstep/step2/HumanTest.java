package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumanTest {

    @Test
    void 사람의_이름은_최대_5자이다() {
        Assertions.assertDoesNotThrow(() -> new Human("abcde"));
        Assertions.assertDoesNotThrow(() -> new Human("abc"));
        Assertions.assertDoesNotThrow(() -> new Human("jk"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Human("Alexander"));
    }

    @Test
    void 사람의_이름에는_공백이나_널이_올_수_없다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Human(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Human(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Human("   "));
    }
}
