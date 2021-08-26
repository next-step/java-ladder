package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("사다리게임 테스트")
class LadderGameTest {

    LadderGame ladderGame;
    DirectionStrategy directionStrategy;

    @BeforeEach
    void setUp() {
        List<String> users = Arrays.asList("red", "blue", "green");
        List<String> results = Arrays.asList("꽝", "1000", "20000");
        ladderGame = new LadderGame(users, results);
        directionStrategy = () -> true;
    }

    @Test
    void ladderGameHeightCheck() {
        // given
        int givenHeightCount = 3;

        // when
        Ladder ladder = ladderGame.generateLadder(givenHeightCount, directionStrategy);
        int ladderHeight = ladder.getLines().size();

        // then
        assertThat(ladderHeight).isEqualTo(givenHeightCount);
    }
}