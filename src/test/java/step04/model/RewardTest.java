package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        Reward reward = new Reward("test");

        // when & then
        assertThat(reward).isEqualTo(new Reward("test"));
    }

    @DisplayName("생성 실패 테스트 - 보상 명이 5자를 초과한 경우")
    @Test
    void create_실패_길이제한초과() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Reward("exceed");
        });
    }

    @DisplayName("names 리스트를 통해 Reward객체 리스트를 만드는 로직 테스트")
    @ParameterizedTest
    @MethodSource("provideRewardNamesAndResult")
    void makeUsersFromNames(List<String> rewardNames, List<LadderUser> expected) {
        // when
        List<Reward> result = Reward.makeRewardsFromNames(rewardNames);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRewardNamesAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("5000", "꽝", "3000"),
                        Arrays.asList(new Reward("5000"), new Reward("꽝"),
                                new Reward("3000"))),
                Arguments.of(Arrays.asList("당첨1", "당첨2", "당첨3"),
                        Arrays.asList(new Reward("당첨1"), new Reward("당첨2"),
                                new Reward("당첨3"))),
                Arguments.of(Arrays.asList("꽝", "꽝", "꽝"),
                        Arrays.asList(new Reward("꽝"), new Reward("꽝"),
                                new Reward("꽝")))
        );
    }
}
