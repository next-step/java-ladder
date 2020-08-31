package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        Ladder ladder = new Ladder(new LadderHeight(5),
                getMockLadderUsers(),
                getMockLines());

        // when
        Ladder expected = new Ladder(new LadderHeight(5),
                getMockLadderUsers(),
                getMockLines());

        // then
        assertThat(ladder).isEqualTo(expected);
    }

    @DisplayName("생성 테스트 - 빌더이용")
    @Test
    void create_use_builder() {
        // given
        Ladder ladder = new Ladder.LadderBuilder(getMockLines())
                .setLadderUsers(getMockLadderUsers())
                .setLadderHeight(new LadderHeight(5))
                .build();

        // when
        Ladder expected = new Ladder(new LadderHeight(5),
                        getMockLadderUsers(),
                        getMockLines());

        // then
        assertThat(ladder).isEqualTo(expected);
    }

    private LadderUsers getMockLadderUsers() {
        LadderUsers ladderUsers = new LadderUsers(User.makeUsersFromNames(
                Arrays.asList("test1", "test2", "test3", "test4")));

        return ladderUsers;
    }

    private Lines getMockLines() {
        return Lines.of(5, 5, (bound) -> Arrays.asList(1, 3));
    }
}
