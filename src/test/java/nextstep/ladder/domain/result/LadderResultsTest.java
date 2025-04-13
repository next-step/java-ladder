package nextstep.ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultsTest {

    @DisplayName("LadderResults 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderResults(List.of("1000")));
    }
}
