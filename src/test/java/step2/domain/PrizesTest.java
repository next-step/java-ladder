package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.IllegalPlayerSizeException;

import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @DisplayName("player 숫자와 경품숫자가 다를경우 익셉션 테스트")
    @Test
    void validateTest() {
        String gifts = "꽝,2000,꽝,3000";
        int playerSize = 3;
        assertThrows(IllegalPlayerSizeException.class, () -> Prizes.of(gifts, playerSize));
    }
}