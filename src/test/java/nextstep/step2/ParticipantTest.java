package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    void 사람의_이름은_최대_5자이다() {
        Assertions.assertDoesNotThrow(() -> new Participant("abcde"));
        Assertions.assertDoesNotThrow(() -> new Participant("abc"));
        Assertions.assertDoesNotThrow(() -> new Participant("jk"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant("Alexander"));
    }

    @Test
    void 사람의_이름에는_공백이나_널이_올_수_없다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Participant("   "));
    }
}
