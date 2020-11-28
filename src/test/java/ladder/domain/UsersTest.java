package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ladder.domain.Users.NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersTest {
    @Test
    void of() {
        // given
        final List<User> userList = Arrays.asList(User.of("pobi"), User.of("min"));

        // when
        final Users users = Users.of(userList);

        // then
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    void of_throw_exception_when_number_of_user_less_then_two() {
        // given
        final List<User> userList = Collections.singletonList(User.of("pobi"));

        // when 
        final Throwable thrown = catchThrowable(() -> {
            Users.of(userList);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
    }

    @Test
    void of_throw_exception_when_user_list_null() {
        // when 
        final Throwable thrown = catchThrowable(() -> {
            Users.of(null);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_USER_MUST_BE_MORE_THEN_TWO);
    }
}
