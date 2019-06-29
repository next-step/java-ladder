package com.jaeyeonling.ladder.view.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersFormatterTest extends FormatterSupport {

    @DisplayName("유저들 포매터 생성에 성공한다.")
    @Test
    void create() {
        // then
        assertThat(usersFormatter).isNotNull();
    }
}
