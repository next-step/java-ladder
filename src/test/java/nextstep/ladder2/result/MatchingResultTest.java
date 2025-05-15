package nextstep.ladder2.result;

import nextstep.ladder2.domain.ladder.Position;
import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.result.LadderResult;
import nextstep.ladder2.domain.result.MatchingResult;
import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MatchingResultTest {

    @Test
    void 플레이어와_보상을_매핑할수있다() {
        Players players = new Players("철수", "영희", "민수");
        Rewards rewards = new Rewards("꽝", "당첨", "행운");
        int rewardsCount = 3;
        List<Position> indexList = Position.listOf(rewardsCount, 1, 2, 0);

        MatchingResult matchingResult = new MatchingResult(indexList);
        LadderResult ladderResult = matchingResult.map(players, rewards);
        
        List<Reward> mappedRewards = ladderResult.rewardList();
        assertThat(mappedRewards).hasSize(3);
        assertThat(mappedRewards.get(0)).isEqualTo(new Reward("당첨")); // 철수 -> 당첨
        assertThat(mappedRewards.get(1)).isEqualTo(new Reward("행운")); // 영희 -> 행운
        assertThat(mappedRewards.get(2)).isEqualTo(new Reward("꽝"));   // 민수 -> 꽝
    }
}