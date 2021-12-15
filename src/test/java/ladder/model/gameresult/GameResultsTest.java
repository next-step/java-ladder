package ladder.model.gameresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultsTest {

    @Test
    @DisplayName("resultOf가 all이면 true 반환 테스트")
    void isAllTrueTest() {
        assertTrue(new GameResults("all").isAll());
        assertTrue(new GameResults("ALL").isAll());
    }

    @Test
    @DisplayName("resultOf가 all이 아니면 false 반환 테스트")
    void isAllFalseTest() {
        assertFalse(new GameResults("a").isAll());
        assertFalse(new GameResults("b").isAll());
    }
}
