package com.jaeyeonling.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @DisplayName("유저들에 여러명을 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_users_when_create_by_comma_separateValue(final String rawUsers) {
        // when
        final Users users = Users.of(rawUsers);
        final int expectLength = rawUsers.split(Users.SEPARATOR).length;

        // then
        assertThat(users.size()).isEqualTo(expectLength);
    }

    @DisplayName("유저들에 1명을 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "d",
            "zzzdd",
            "김재연"
    })
    void should_return_users_when_create_by_single_username(final String singleUsername) {
        // when
        final Users users = Users.of(singleUsername);

        // then
        assertThat(users).isNotNull();
    }
}
