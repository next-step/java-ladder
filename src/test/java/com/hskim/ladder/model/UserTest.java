package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        User user = new User(new UserName("test"));

        // when & then
        assertThat(user).isEqualTo(new User(new UserName("test")));
    }

    @DisplayName("UserName 객체 리스트를 통해 User 객체 리스트를 만드는 로직 테스트")
    @ParameterizedTest
    @MethodSource("provideUserNamesAndResult")
    void makeUsersFromNames(List<UserName> userNames, List<User> expected) {
        // when
        List<User> result = User.makeUsersFromNames(userNames);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideUserNamesAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(new UserName("kim"), new UserName("hs"), new UserName("test")),
                        Arrays.asList(new User(new UserName("kim")), new User(new UserName("hs")),
                                new User(new UserName("test")))),
                Arguments.of(Arrays.asList(new UserName("name1"), new UserName("name2"), new UserName("name3")),
                        Arrays.asList(new User(new UserName("name1")), new User(new UserName("name2")),
                                new User(new UserName("name3")))),
                Arguments.of(Arrays.asList(new UserName("hard"), new UserName("to"), new UserName("test")),
                        Arrays.asList(new User(new UserName("hard")), new User(new UserName("to")),
                                new User(new UserName("test"))))
        );
    }
}
