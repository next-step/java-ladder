package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Lane;
import nextstep.ladder.domain.ladder.TestLadder;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.domain.reward.TestRewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderBoardTest {

    @Test
    @DisplayName("시작 레인에서 출발하여 사다리를 통과한 후, 해당 레인의 보상을 가져온다.")
    void getRewardByLane() {
        Ladder ladder = TestLadder.ladder();
        Rewards rewards = TestRewards.rewards();

        LadderBoard ladderBoard = new LadderBoard(ladder, rewards);

        Lane lane0 = Lane.wrap(0);
        Lane lane1 = Lane.wrap(1);
        Lane lane2 = Lane.wrap(2);
        Lane lane3 = Lane.wrap(3);

        assertAll(
            () -> assertThat(ladderBoard.getReward(lane0)).isEqualTo(rewards.getReward(lane0)),
            () -> assertThat(ladderBoard.getReward(lane1)).isEqualTo(rewards.getReward(lane3)),
            () -> assertThat(ladderBoard.getReward(lane2)).isEqualTo(rewards.getReward(lane2)),
            () -> assertThat(ladderBoard.getReward(lane3)).isEqualTo(rewards.getReward(lane1))
        );
    }
    
}
