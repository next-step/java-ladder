package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.ladder.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    @DisplayName("Users 생성")
    void create() {
        assertThat(Users.fromString("a,b,c,d,e")).isInstanceOf(Users.class);
    }

    @Test
    @DisplayName("Users 생성시 이름 중복이면 예외")
    void create_should_throw_exception_when_username_duplicate() {
        assertThatThrownBy(()->Users.fromString("a,b,c,d,d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.USER_NAME_DUPLICATED.getMessage());
    }

    @Test
    @DisplayName("가장 이름이 긴 유저의 이름 길이")
    void longestUserNameLength() {
        assertThat(Users.fromString("aa,b,c,d,e").longestUserNameLength()).isEqualTo(2);
    }

    @Test
    @DisplayName("Users의 길이")
    void size() {
        assertThat(Users.fromString("aa,b,c,d,e").size()).isEqualTo(5);
    }

    @Test
    @DisplayName("Users 이름")
    void toStringTest() {
        assertThat(Users.fromString("aa,bbbbb,c,d,e")).hasToString("   aa bbbbb     c     d     e");
    }

    @Test
    @DisplayName("첫 유저의 이름 길이")
    void firstUsernameLength() {
        assertThat(Users.fromString("aa,bbbbb,c,d,e").firstUsernameLength()).isEqualTo(2);
    }
}
