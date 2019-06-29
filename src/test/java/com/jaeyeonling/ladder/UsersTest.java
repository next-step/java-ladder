package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @DisplayName("유저들에 1명을 생성에 성공한다.")
    @Test
    void Create() {
        // given
        final String rawUsers = "user";

        // when
        final Users users = Users.of(rawUsers);

        // then
        assertThat(users).isNotNull();
    }

    @DisplayName("유저들에 여러명을 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void Create_CommaValue(final String rawUsers) {
        // when
        final Users users = Users.of(rawUsers);
        final int expectLength = rawUsers.split(Users.SEPARATOR).length;

        // then
        assertThat(users.size()).isEqualTo(expectLength);
    }
}
