package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.exception.LongerThanMaxLengthUsernameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("유저 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "T",
            "TEST!"
    })
    void should_return_user_when_create_by_username(final String username) {
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
    void should_throw_LongerThanMaxLengthUsernameException_when_create_by_longerThanMaxLengthUsername(
            final String longerThanMaxLengthUsername) {
        Assertions.assertThatExceptionOfType(LongerThanMaxLengthUsernameException.class)
                .isThrownBy(() -> {
                    User.of(longerThanMaxLengthUsername);
                });
    }

    @DisplayName("유저 이름이 같다면 같은 객체여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void should_equals_object_when_create_by_same_username(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);
        final User expect = User.of(rawUsername);

        // when
        final boolean equals = user.equals(expect);

        // then
        assertThat(equals).isTrue();
        assertThat(user == expect).isTrue();
    }

    @DisplayName("유저 이름 같으면 유저 이름은 같다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void should_return_true_equalsName(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);

        // when
        final boolean equals = user.equalsUsername(rawUsername);

        // then
        assertThat(equals).isTrue();
    }

    @DisplayName("유저 이름이 다르면 유저 이름은 다르다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg"
    })
    void should_return_false_otherUsername(final String rawUsername) {
        // given
        final User user = User.of(rawUsername);
        final String username = "XXXXX";

        // when
        final boolean equals = user.equalsUsername(username);

        // then
        assertThat(equals).isFalse();
    }
}
