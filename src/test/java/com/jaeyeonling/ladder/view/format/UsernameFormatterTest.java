package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsernameFormatterTest {

    @DisplayName("유저 이름 포매터 생성에 성공한다.")
    @Test
    void create() {
        // when
        final Formatter<Username> usernameFormatter = new UsernameFormatter();

        // then
        assertThat(usernameFormatter).isNotNull();
    }
}
