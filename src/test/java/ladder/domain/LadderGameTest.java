package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.exception.LadderGameDifferentSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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
    @DisplayName("사다리 생성 후 사다리 높이 확인")
    void ladderGameHeightCheck() {
        // given
        int givenHeightCount = 3;

        // when
        Ladder ladder = ladderGame.generateLadder(givenHeightCount, directionStrategy);
        int ladderHeight = ladder.getLines().size();

        // then
        assertThat(ladderHeight).isEqualTo(givenHeightCount);
    }

    @Test
    @DisplayName("유저 수와 결과 수 크기가 같지 않다면 Exception")
    void ladderGameArgumentDifferentInSizeException() {
        // given
        List<String> users = Arrays.asList("user1", "user2", "user3");
        List<String> results = Arrays.asList("result1", "result2");

        // when
        // then
        assertThatThrownBy(() -> new LadderGame(users, results))
                .isInstanceOf(LadderGameDifferentSizeException.class);
    }
}