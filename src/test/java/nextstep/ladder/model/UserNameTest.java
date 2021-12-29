package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {
    public static final UserName CRONG = new UserName("crong");
    public static final UserName POBI = new UserName("pobi");

    @Test
    void createTest() {
        // when & then
        assertThat(new UserName("crong")).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionWithNullOrEmptyNameTest(String invalidName) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new UserName(invalidName)
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
