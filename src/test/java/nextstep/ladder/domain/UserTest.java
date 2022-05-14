package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Nested
    class 생성자는 {

        @Nested
        class null혹은_빈값이_주어진경우 {

            @ParameterizedTest
            @NullAndEmptySource
            void CannotNullOrEmptyException을_던진다(String nullOrEmptySource) {
                assertThatThrownBy(() -> new User(nullOrEmptySource))
                        .isInstanceOf(User.CannotNullOrEmptyException.class);
            }

        }

        @Nested
        class _5글자가넘는_문자열이_주어질경우 {

            @ParameterizedTest
            @ValueSource(strings = {"123456"})
            void ExceedMaxNameLengthException을_던진다(String name) {
                assertThatThrownBy(() -> new User(name))
                        .isInstanceOf(User.ExceedMaxNameLengthException.class);
            }

        }
    }
}
