package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsernameTest {

    @DisplayName("유저 이름 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void Create(final String rawUsername) {
        final Username username = Username.of(rawUsername);
    }
}
