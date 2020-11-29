package ladder.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.user.User.USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE;
import static ladder.domain.user.User.USER_NAME_MUST_NOT_BE_BLANK;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UserTest {
    @DisplayName("정적 팩터리 메서드를 이용한 생성")
    @Test
    void of() {
        // given
        final String userName = "pobi";

        // when
        final User user = User.of(userName);

        // then
        assertThat(user).isNotNull();
    }

    @Test
    void of_throw_exception_when_name_blank() {
        // given
        final String userName = "";

        // when 
        final Throwable thrown = catchThrowable(() -> {
            User.of(userName);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(USER_NAME_MUST_NOT_BE_BLANK);
    }

    @Test
    void of_throw_exception_when_name_length_grate_then_five() {
        // given
        final String userName = "123456";

        // when 
        final Throwable thrown = catchThrowable(() -> {
            User.of(userName);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(USER_NAME_LENGTH_MUST_NOT_MORE_THEN_FIVE);
    }

}