package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameMakerTest {

    @Test
    @DisplayName("참가자 수와 보상의 수가 맞지 않으면 예외 처리한다.")
    void throwExceptionIfSizeNotEqualBetweenPlayersAndRewards() {
        Players players = Players.of(Arrays.asList("crong", "honux", "jk"));
        Rewards rewards = Rewards.of(Arrays.asList("꽝", "3000", "5000", "꽝"));

        assertThatThrownBy(() -> LadderGameMaker.makeRandomLadderGame(players, rewards, 1))
            .isInstanceOf(RuntimeException.class);
    }
    

}
