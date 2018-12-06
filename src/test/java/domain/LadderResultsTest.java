package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
public class LadderResultsTest {

    @Test
    public void 결과를_입력받는다() {
        new Reward("꽝,담첨,꽝,꽝", new Players("홍길동,홍길순,나인제로,둘리"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값이_NULL이면_예외를_던진다() {
        new Reward(null, new Players("홍길동,홍길순,나인제로,둘리"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값이_빈값이면_예외를_던진다() {
        new Reward("", new Players("홍길동,홍길순,나인제로,둘리"));
    }

    @Test
    public void 결과값의_길이를_콤마를_구분자로_나눈다() {
        final Reward ladderReward = new Reward("꽝,담첨,꽝,꽝", new Players("홍길동,홍길순,나인제로,둘리"));
        assertThat(ladderReward.rewardsSize()).isEqualTo(4);
    }

    @Test
    public void 결과값의_숫자는_참가자_숫자와_같아야한다() {
        new Reward("꽝,담첨,꽝,꽝", new Players("홍길동,홍길순,나인제로,둘리"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값의_숫자가_참가자_숫자와_다르면_예외를_던진다() {
        new Reward("꽝,담첨,꽝,꽝", new Players("홍길동,홍길순,나인제로"));
    }

    @Test
    public void 참가자_번호로_어떤_보상을_받을수_있는지_검사() {

        final Reward ladderReward = new Reward("꽝1,당첨,꽝2,꽝3", new Players("홍길동,홍길순,나인제로,둘리"));

        final String reward1 = ladderReward.findReward(0);
        assertThat(reward1).isEqualTo("꽝1");

        final String reward2 = ladderReward.findReward(1);
        assertThat(reward2).isEqualTo("당첨");
    }

}
