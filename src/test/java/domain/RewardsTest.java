package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
public class RewardsTest {

    @Test
    public void 입력_받은_결과값이_만들어졌는지_검증() {
        final String[] values = {"꽝", "당첨", "꽝", "꽝"};
        final Rewards rewards = new Rewards(values);
        assertThat(rewards.eqRewards(values)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값이_NULL_이면_예외를_던진다() {
        new Rewards(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값의_목록의_사이즈가_0이면_예외를_던진다() {
        new Rewards(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값중_NULL값이_있는_경우_예외를_던진다() {
        new Rewards(new String[]{"당첨", "꽝", null});
    }

    @Test
    public void 참가자_번호로_보상_구하기() {

        final Rewards rewards = new Rewards(new String[]{"꽝1", "당첨", "꽝2", "꽝3"});

        final String reward1 = rewards.findReward(0);
        assertThat(reward1).isEqualTo("꽝1");

        final String reward2 = rewards.findReward(1);
        assertThat(reward2).isEqualTo("당첨");

        final String reward3 = rewards.findReward(2);
        assertThat(reward3).isEqualTo("꽝2");

        final String reward4 = rewards.findReward(3);
        assertThat(reward4).isEqualTo("꽝3");
    }
}
