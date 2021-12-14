package ladder.model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Player의 이름과 동일한지 체크하는 로직 테스트")
    void isNameCheckTest() {
        assertTrue(new Player("이름1").isName("이름1"));
        assertFalse(new Player("이름1").isName("이름2"));
    }
}
