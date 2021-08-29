package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 게임에 참여를 할 수 있다.")
    @Test
    void ladder() {
        // given
        LadderHeight heightOfLadder = LadderHeight.of(5);

        Players players = PlayerFactory.playerFixture("phob", "phob1", "phob2");

        // when
        Ladder ladder = Ladder.of(players, heightOfLadder);

        // then
        assertThat(LadderHeight.of(ladder.lines().size())).isEqualTo(heightOfLadder);
        assertThat(players.size()).isEqualTo(3);
    }


}
