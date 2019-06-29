package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.User;
import com.jaeyeonling.ladder.Username;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserFormatterTest extends FormatterSupport {

    @DisplayName("유저 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(userFormatter).isNotNull();
    }

    @DisplayName("포맷팅 시 길이는 " + Username.MAX_LENGTH + " 이어야 한다.")
    @Test
    void should_equals_formattedUser_and_maxUsernameLength(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);

        // when
        final String formattedUser = userFormatter.format(user);

        // then
        assertThat(formattedUser).hasSize(Username.MAX_LENGTH);
    }

    @DisplayName("포맷팅 후 trim 시 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void should_equals_formattedUser_and_trimInputValue(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);

        // when
        final String formattedUsername = userFormatter.format(user).trim();

        // then
        assertThat(formattedUsername).isEqualTo(rawUsername);
    }
}
