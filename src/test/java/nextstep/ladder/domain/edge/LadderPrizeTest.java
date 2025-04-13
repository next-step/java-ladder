package nextstep.ladder.domain.edge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrizeTest {

    @DisplayName("LadderResult 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderPrize("꽝"));
    }
}
