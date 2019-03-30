package ladder.domain.result;

import ladder.domain.enums.Complexity;
import ladder.domain.ladder.Ladder;
import ladder.domain.players.Players;
import ladder.domain.rewards.Rewards;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LadderGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어수와_보상의수가_다른경우() {
        String playerNames = "1,2,3,4";
        String rewardNames = "5,6,7,8,9";

        Players players = Players.generate(playerNames);

        Ladder ladder = new Ladder();
        ladder.generate(Complexity.EASY, players.size());

        Rewards rewards = Rewards.generate(rewardNames, players);

        LadderGame.generate(players, rewards);
    }

    @Test
    public void 사다리게임결과_반환() {
        String playerNames = "1,2,3,4";
        String rewardNames = "5,6,7,8";

        Players players = Players.generate(playerNames);

        Ladder ladder = new Ladder();
        ladder.generate(Complexity.EASY, players.size());

        Rewards rewards = Rewards.generate(rewardNames, players);

        LadderGame ladderGame = LadderGame.generate(players, rewards);

        assertThat(ladderGame.result(ladder), instanceOf(LadderResult.class));
    }
}
