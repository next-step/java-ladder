package ladder;

import ladder.model.Result;
import ladder.model.group.Rewards;
import ladder.model.move.Point;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultTest {
    @Test
    public void 비정상_생성(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Result.of(Collections.emptyMap(), Rewards.from("a,b", 2)))
                .withMessageMatching("결과가 없습니다.");
    }

    @Test
    public void 정상_결과_반환(){
        Result result = getResult();

        assertThat(result.getReward("user1")).isEqualTo("a");
        assertThat(result.getReward("user2")).isEqualTo("b");
        assertThat(result.getReward("user3")).isEqualTo("c");
    }

    @Test
    public void 결과에_이름이_없는_경우(){
        Result result = getResult();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> result.getReward("user4"))
                .withMessageMatching("결과가 없는 유저입니다.");
    }

    private Result getResult(){
        Map<String, Point> rewards = new LinkedHashMap();
        rewards.put("user1", Point.rewardPoint(0,3));
        rewards.put("user2", Point.rewardPoint(1,3));
        rewards.put("user3", Point.rewardPoint(2,3));

        return Result.of(rewards, Rewards.from("a,b,c", 3));
    }
}
