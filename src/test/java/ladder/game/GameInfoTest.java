package ladder.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameInfoTest {
    @Test
    void constructorExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new GameInfo("숫자가,맞지,않을때", "게임,결과"));
    }
}