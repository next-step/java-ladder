package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.result.Result;
import ladder.exception.LadderLackOfUserException;
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
    @DisplayName("사용자 이름을 받아 사다리 실행 결과값을 준다.")
    void ladderGameRun() {
        // given
        int ladderHeight = 2;
        String username = "red";
        Ladder ladder = ladderGame.generateLadder(ladderHeight, directionStrategy);

        // when
        Result actual = ladderGame.executionLadderGame(ladder, username);

        // then
        assertThat(actual).isEqualTo(new Result("꽝"));
    }
}