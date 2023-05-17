package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 참여자의_이름이_5글자를_초과하면_예외를_던진다() {
        final var name = "abcdef";

        assertThrows(
                IllegalArgumentException.class,
                () -> new Name(name)
        );
    }
}
