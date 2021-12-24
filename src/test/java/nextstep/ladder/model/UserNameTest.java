package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {
    public static final UserName CRONG = new UserName("crong");
    public static final UserName RYAN = new UserName("ryan");

    @Test
    void createTest() {
        // when & then
        assertThat(new UserName("crong")).isNotNull();
    }

    @Test
    void checkExceptionWithNullNameTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new UserName(null)
        );
    }

    @Test
    void checkExceptionWithNameGreaterThan5LetterTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new UserName("crong-kim")
        );
    }
}
