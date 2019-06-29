package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
