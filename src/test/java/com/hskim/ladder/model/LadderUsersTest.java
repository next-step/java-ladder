package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
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
        return Arrays.asList(
                new User("test1"),
                new User("test2"),
                new User("test3")
        );
    }

    @DisplayName("유저가 현재 객체에 포함되어 있는지 판별하는 contains() 로직 검증")
    @ParameterizedTest
    @MethodSource("provideUserAndResult")
    void contains(User user, boolean expected) {
        // given
        LadderUsers ladderUsers = new LadderUsers(makeMockUsers());

        // when
        boolean result = ladderUsers.contains(user);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideUserAndResult() {
        return Stream.of(
                Arguments.of(new User("test1"), true),
                Arguments.of(new User("no1"), false),
                Arguments.of(new User("test3"), true),
                Arguments.of(new User("mock"), false)
        );
    }
}
