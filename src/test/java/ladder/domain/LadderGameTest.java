package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.exception.LadderLackOfUserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("사다리게임 테스트")
class LadderGameTest {

    @Test
    void ladderGameHeightCheck() {
        // given
        String[] givenUsers = {"red", "blue", "green"};
        int givenHeightCount = 3;
        LadderGame ladderGame = new LadderGame(givenUsers);
        DirectionStrategy directionStrategy = () -> true;

        // when
        Ladder ladder = ladderGame.generateLadder(givenHeightCount, directionStrategy);
        int ladderHeight = ladder.getLines().size();

        // then
        assertThat(ladderHeight).isEqualTo(givenHeightCount);
    }

    @Test
    @DisplayName("참여할사람 수가 없을때 Exception 발생")
    void ladderGameNoneUserException() {
        assertThatThrownBy(() -> new LadderGame(new String[]{"unknown1, unknown2"}))
                .isInstanceOf(LadderLackOfUserException.class);
    }
}