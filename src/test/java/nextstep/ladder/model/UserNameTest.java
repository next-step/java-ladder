package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNameTest {

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
