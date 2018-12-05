package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderGameTest {

    @Test
    public void 사다리_게임() {
        String names = "aa,bb,cc,dd,ee";
        String rewards = "0,0,1000,0,3000";

        int height = 5;

        LadderGame ladderGame = LadderGame.of(names, rewards, height);

        assertThat(ladderGame.getPeople()).isEqualTo(People.of(names));
        assertThat(ladderGame.getRewards()).isEqualTo(Rewards.of(rewards));
        assertThat(ladderGame.getLadder().size()).isEqualTo(5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리_게임_사용자와_결과개수가_다른경우() {
        String names = "aa,bb,cc,dd,ee";
        String rewards = "0,0,1000,0,3000,1111";

        int height = 5;

        LadderGame.of(names, rewards, height);
    }

    @Test
    public void 사다리게임_결과() {
        String names = "aa,bb,cc,dd,ee";
        String rewards = "0,0,1000,0,3000";

        int height = 5;

        LadderGame ladderGame = LadderGame.of(names, rewards, height);
        LadderResult result = ladderGame.result();

        result.getRewardByPerson("aa");
        result.getRewardByPerson("bb");
    }
}