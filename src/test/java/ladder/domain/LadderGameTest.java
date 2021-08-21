package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.exception.LadderLackOfUserException;
import ladder.exception.LadderMinimumHeightException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("사다리게임 테스트")
class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        String[] users = {"red", "blue", "green"};
        int ladderHeight = 3;
        ladderGame = new LadderGame(ladderHeight, users);
    }

    @Test
    void ladderGameHeightCheck() {
        // given
        int givenHeightCount = 3;
        LadderGame ladderGame = new LadderGame(givenHeightCount, "red", "blue", "green");
        DirectionStrategy directionStrategy = () -> true;

        // when
        Ladder ladder = ladderGame.start(directionStrategy);
        int ladderHeight = ladder.getLines().size();

        // then
        assertThat(ladderHeight).isEqualTo(givenHeightCount);
    }

    @Test
    @DisplayName("사다리 높이가 낮을 때 Exception 발생")
    void ladderGameMinimumHeightException() {
        assertThatThrownBy(() -> new LadderGame(Ladder.MIN_HEIGHT - 1, "unknown1, unknown2"))
                .isInstanceOf(LadderMinimumHeightException.class);
    }

    @Test
    @DisplayName("참여할사람 수가 없을때 Exception 발생")
    void ladderGameNoneUserException() {
        assertThatThrownBy(() -> new LadderGame(Ladder.MIN_HEIGHT, "unknown"))
                .isInstanceOf(LadderLackOfUserException.class);
    }
}