package nextstep.ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @DisplayName("LadderResult 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderResult("꽝"));
    }
}
