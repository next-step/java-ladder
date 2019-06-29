package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("유저 생성에 성공한다.")
    @Test
    void Create() {
        // given
        final Username username = Username.of("TEST");

        // when
        final User user = User.of(username);

        // then
        assertThat(user).isNotNull();
    }
}
