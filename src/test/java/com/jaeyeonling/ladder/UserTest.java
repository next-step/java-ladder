package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.exception.LongerThanMaxLengthUsernameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("유저 생성에 성공한다.")
    @Test
    void Create() {
        // given
        final Username username = Username.of("TEST");

        // when
        final User user = User.of(username);

        // then
        assertThat(user).isNotNull();
    }

    @DisplayName("유저 이름에 길이가 " + Username.MAX_LENGTH + " 를 넘는 값이 들어가면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연123",
            "mattsdasda",
            "kjysgadasadgads",
            "gggdsa 아ㅏㅏㅏㅏㅏ sadsas "
    })
    void Create_LongerThanMaxLengthUsername_ThrowException(final String longerThanMaxLengthUsername) {
        Assertions.assertThatExceptionOfType(LongerThanMaxLengthUsernameException.class)
                .isThrownBy(() -> {
                    User.of(longerThanMaxLengthUsername);
                });
    }
}
