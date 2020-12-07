package ladder;

import ladder.model.Result;
import ladder.model.group.Rewards;
import ladder.model.move.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultTest {
    @Test
    public void 비정상_생성(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Result.of(Collections.emptyMap(), Rewards.from("a,b", 2)))
                .withMessageMatching("결과가 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("resultParams")
    public void 정상_결과_반환(String userName, String rewardName){
        Result result = getResult();

        assertThat(result.getReward(userName)).isEqualTo(rewardName);

    }

    private static Stream<Arguments> resultParams() {
        return Stream.of(
                Arguments.of("user1", "a"),
                Arguments.of("user2", "b"),
                Arguments.of("user3", "c")
        );
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
