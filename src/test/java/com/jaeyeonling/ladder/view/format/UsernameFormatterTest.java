package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("포맷팅 시 길이는 " + Username.MAX_LENGTH + " 이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void Format_Username_LengthShouldSame(final String rawUsername) {
        // given
        final Username username = Username.of(rawUsername);
        final Formatter<Username> usernameFormatter = new UsernameFormatter();

        // when
        final String formattedUsername = usernameFormatter.format(username);

        // then
        assertThat(formattedUsername).hasSize(Username.MAX_LENGTH);
    }
}
