package nextstep.ladder.domain.result;

import nextstep.ladder.domain.edge.LadderPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @DisplayName("LadderResult 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderPrize("꽝"));
    }
}
