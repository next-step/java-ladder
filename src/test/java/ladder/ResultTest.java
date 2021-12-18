package ladder;

import ladder.domain.Players;
import ladder.domain.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultTest {

    @Test
    @DisplayName("결과 입력")
    void inputResult() {
        assertDoesNotThrow(() -> Results.of("꽝,1000,꽝,5000", Players.of("p1,p2,p3,p4")));
    }
}
