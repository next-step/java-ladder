package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    private LadderUsers getMockLadderUsers() {
        List<UserName> userNames = UserName.makeUserNamesFromNames(Arrays.asList("test1", "test2", "test3", "test4"));
        LadderUsers ladderUsers = new LadderUsers(User.makeUsersFromNames(userNames));

        return ladderUsers;
    }

    private Lines getMockLines() {
        return Lines.of(5, 5, (bound) -> Arrays.asList(1, 3));
    }
}
