package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Ladder(List.of("pobi", "honux", "crong", "jk"), 3));
    }
}
