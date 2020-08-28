package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderUsersTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LadderUsers ladderUsers = new LadderUsers(makeMockUsers());

        // when & then
        assertThat(ladderUsers).isEqualTo(new LadderUsers(makeMockUsers()));
    }

    private List<User> makeMockUsers() {
        return Stream.of(
                new User("test1"),
                new User("test2"),
                new User("test3"))
                .collect(Collectors.toList());
    }
}
