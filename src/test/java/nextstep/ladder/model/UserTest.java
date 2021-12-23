package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {
    private static final String CRONG = "crong";
    private static final UserName VALID_NAME_CRONG = new UserName(CRONG);

    @Test
    void createTest() {
        // when & then
        assertThat(new User(VALID_NAME_CRONG)).isNotNull();
    }

    @Test
    void checkExceptionWithNullNameTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new User(null)
        );
    }

    @Test
    void getNameTest() {
        // when
        User user = new User(VALID_NAME_CRONG);
        // then
        assertThat(user.getName()).isEqualTo(CRONG);
    }
}
