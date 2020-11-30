package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UsersTest {

    Users users;

    @Test
    @DisplayName("참여자가 2명이상이 아닐 경우 예외처리")
    void multipleUsers() {
        String names = "java";
        assertThrows(IllegalArgumentException.class,
                () -> new Users(names));
    }
}
