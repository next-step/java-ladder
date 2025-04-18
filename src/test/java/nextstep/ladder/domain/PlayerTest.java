package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void 이름이_정상적으로_생성되는_경우() {
        assertDoesNotThrow(() -> new Player("pobi"));
    }

    @Test
    void 이름이_빈_문자열이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void 이름이_5자를_초과하면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Player("longname"));
    }

    @Test
    void 숫자만_이름이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Player("1234"));
    }

    @Test
    void 특수문자_포함_이름이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Player("hi!"));
    }
}
