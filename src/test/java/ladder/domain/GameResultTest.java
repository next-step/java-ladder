package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    private LadderGoals ladderGoals;
    private Users users;
    private GameResult ladderGame;

    @BeforeEach
    void setUp() {
        ladderGoals = new GoalsGenerator("5000, 꽝").generate();
    }

    @DisplayName("사다리의 골과 사용자 숫자가 일치하는지 테스트")
    @Test
    void testGoalsAndUserCounts() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameResult(twoUsers(), new LadderGame(fiveHeightLadder(), fourLadderGoals()));
        });
    }


}
