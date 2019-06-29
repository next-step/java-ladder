package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountOfUsersTest {

    @DisplayName("유저의 갯수를 생성에 성공한다.")
    @Test
    void should_return_countOfUsers_when_usersGetCountOfUsers() {
        // when
        final Users users = Users.of("a,b,c");
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        // then
        assertThat(countOfUsers).isNotNull();
    }

    @DisplayName("유저의 갯수가 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_equalsObject_when_sameUsers(final String rawUsers) {
        // given
        final Users users = Users.of(rawUsers);
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Users expectUsers = Users.of(rawUsers);
        final CountOfUsers expectCountOfUsers = expectUsers.getCountOfUsers();

        // when
        final boolean equals = countOfUsers.equals(expectCountOfUsers);

        // then
        assertThat(equals).isTrue();
        assertThat(countOfUsers == expectCountOfUsers).isTrue();
    }
}