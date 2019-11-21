package ladder.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    @Test
    void constructorExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Prize("이름이 길 때 예외 발생"));
    }
}