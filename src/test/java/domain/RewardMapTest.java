package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardMapTest {

    @Test(expected = IllegalArgumentException.class)
    public void 없는_이름으로_조회_시_Exception() {
        RewardMap rewardMap = new RewardMap(ParticipantsTest.DEFAULT_PARTICIPANTS, RewardsTest.DEFAULT_REWARDS);
        rewardMap.viewResult("ccc");
    }

    @Test
    public void 결과_매칭_올바르게_됨() {
        PlayResults results = new PlayResults();
        results.add(new PlayResult(Position.from(0), Position.from(1)));
        results.add(new PlayResult(Position.from(1), Position.from(2)));
        results.add(new PlayResult(Position.from(2), Position.from(0)));

        RewardMap rewardMap = new RewardMap(ParticipantsTest.DEFAULT_PARTICIPANTS, RewardsTest.DEFAULT_REWARDS);
        rewardMap.initMapFromResult(results);

        assertThat(rewardMap.viewResult("aaa")).isEqualTo("bad");
    }
}