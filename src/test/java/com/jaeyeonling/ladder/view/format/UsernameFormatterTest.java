package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.user.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UsernameFormatterTest extends FormatterSupport {

    @DisplayName("유저 이름 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(usernameFormatter).isNotNull();
    }

    @DisplayName("포맷팅 후 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void should_equals_formattedUsername_and_username(final String rawUsername) {
        // given
        final Username username = Username.of(rawUsername);

        // when
        final String formattedUsername = usernameFormatter.format(username);

        // then
        assertThat(formattedUsername).isEqualTo(rawUsername);
    }
}
