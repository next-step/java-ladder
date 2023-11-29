package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    @DisplayName("User 생성")
    void create() {
        assertThat(User.from("pobi"))
                .isInstanceOf(User.class)
                .isEqualTo(User.from("pobi"));
    }

    @Test
    @DisplayName("User 생성")
    void create_should_throw_exception_when_name_length_over_5() {
        assertThatThrownBy(()->Users.fromString("fineroot"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.USER_NAME_LENGTH_OVER.getMessage());
    }

    @Test
    @DisplayName("User 생성")
    void create_should_throw_exception_when_name_isEmpty() {
        assertThatThrownBy(()->Users.fromString(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.USER_NAME_EMPTY.getMessage());
    }
}
