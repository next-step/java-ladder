package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @DisplayName("포지션이 같으면 동일 선상이다.")
    @Test
    void samePotision() {
        assertEquals(new Position(1), new Position(1));
    }
}