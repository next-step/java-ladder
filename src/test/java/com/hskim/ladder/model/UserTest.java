package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
