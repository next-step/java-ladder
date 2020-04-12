package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.Fixture.*;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @DisplayName("사다리의 골과 사용자 숫자가 일치하는지 테스트")
    @Test
    void testGoalsAndUserCounts() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameResult(twoUsers(), fiveHeightLadder(), fourLadderGoals());
        });
    }

}
