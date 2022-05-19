package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.result.Results;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.LineTest.LEFT_LINE;
import static ladder.domain.ladder.LineTest.UNCONNECTED_LINE;
import static ladder.domain.player.PlayerTest.PLAYER_ONE;
import static ladder.domain.player.PlayerTest.PLAYER_ONE_NAME;
import static ladder.domain.player.PlayerTest.PLAYER_TWO;
import static ladder.domain.reward.RewardTest.REWARD_ONE;
import static ladder.domain.reward.RewardTest.REWARD_ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LadderGameTest {
    @Test
    void LadderGame는_ladder_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new LadderGame(null, new Rewards(List.of(REWARD_ZERO)))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LadderGame는_rewards_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new LadderGame(new Ladder(List.of(LEFT_LINE)), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play는_players의_결과_results를_반환한다() {
        LadderGame ladderGame = new LadderGame(
                new Ladder(List.of(UNCONNECTED_LINE, UNCONNECTED_LINE)),
                new Rewards(List.of(REWARD_ZERO, REWARD_ONE))
        );
        Players players = new Players(List.of(PLAYER_ONE, PLAYER_TWO));

        Results results = ladderGame.play(players);

        assertAll(
                () -> assertInstanceOf(Results.class, results),
                () -> assertThat(results.findByPlayerName(PLAYER_ONE_NAME).reward()).isEqualTo(REWARD_ZERO)
        );
    }
}
