package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {
    public static final User CRONG = new User(UserNameTest.CRONG);
    public static final User POBI = new User(UserNameTest.POBI);

    @Test
    void createTest() {
        // when & then
        assertThat(new User(UserNameTest.CRONG)).isNotNull();
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
        User user = new User(UserNameTest.CRONG);
        // then
        assertThat(user.getName()).isEqualTo(UserNameTest.CRONG.getName());
    }
}
