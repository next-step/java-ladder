package ladder.domain.ladder;

import ladder.domain.ladders.LadderGame;
import ladder.domain.ladders.reward.Prize;
import ladder.domain.participants.Position;
import ladder.domain.result.GameRewardsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    public static final LadderGame LADDER_GAME = new LadderGame(LadderTest.ladder, GameRewardsTest.gameResult);

    @Test
    void get_reward_by_position() {
        assertThat(LADDER_GAME.getRewardBy(new Position(0))).isEqualTo(new Prize("item2"));
    }
}