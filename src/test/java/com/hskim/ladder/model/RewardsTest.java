package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given & when & then
        new Rewards(makeMockRewards3Elements(), makeMockLadderUsers3Elements());
    }

    private List<Reward> makeMockRewards3Elements() {
        return Arrays.asList(
                new Reward("abc"),
                new Reward("efg"),
                new Reward("hij")
        );
    }

    private LadderUsers makeMockLadderUsers3Elements() {
        return new LadderUsers(Arrays.asList(
                new User("test1"),
                new User("test2"),
                new User("test3"))
        );
    }

    @DisplayName("생성 실패 - 유저수와 보상수가 일치하지 않는 경우")
    @Test
    void create_유저수_보상수_불일치_실패() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Rewards(makeMockRewards5Elements(), makeMockLadderUsers4Elements());
        });
    }

    private List<Reward> makeMockRewards5Elements() {
        return Arrays.asList(
                new Reward("abc"),
                new Reward("efg"),
                new Reward("hij"),
                new Reward("klm"),
                new Reward("nop")
        );
    }

    private LadderUsers makeMockLadderUsers4Elements() {
        return new LadderUsers(Arrays.asList(
                new User("test1"),
                new User("test2"),
                new User("test3"),
                new User("test4")
        ));
    }
}
