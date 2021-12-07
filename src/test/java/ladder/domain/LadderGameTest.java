package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderGameTest {

    @DisplayName("names와 height로 사다리게임 생성")
    @Test
    void create() {
        assertDoesNotThrow(() -> new LadderGame("pobi, honux, crong, jk", 1));
    }

}
