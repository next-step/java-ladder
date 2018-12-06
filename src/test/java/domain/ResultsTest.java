package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
public class ResultsTest {

    @Test
    public void 입력_받은_결과값이_만들어졌는지_검증() {
        final String[] values = {"꽝", "당첨", "꽝", "꽝"};
        final Results results = new Results(values);
        assertThat(results.eqRewards(values)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값이_NULL_이면_예외를_던진다() {
        new Results(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값의_목록의_사이즈가_0이면_예외를_던진다() {
        new Results(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과값중_NULL값이_있는_경우_예외를_던진다() {
        new Results(new String[]{"당첨", "꽝", null});
    }

    @Test
    public void 참가자_번호로_보상_구하기() {

        final Results results = new Results(new String[]{"꽝1", "당첨", "꽝2", "꽝3"});

        final String reward1 = results.findReward(0);
        assertThat(reward1).isEqualTo("꽝1");

        final String reward2 = results.findReward(1);
        assertThat(reward2).isEqualTo("당첨");

        final String reward3 = results.findReward(2);
        assertThat(reward3).isEqualTo("꽝2");

        final String reward4 = results.findReward(3);
        assertThat(reward4).isEqualTo("꽝3");
    }
}
