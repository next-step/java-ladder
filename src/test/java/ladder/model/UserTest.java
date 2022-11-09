package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class UserTest {
    @ParameterizedTest
    @NullAndEmptySource
    void testFailWhenNullAndEmptyName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new User(name));
    }

    @Test
    void testFailWhenExceedLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> new User("abcdef"));
    }

    @Test
    void testSuccessWhenCreateUser() {
        assertThatNoException().isThrownBy(() -> new User("a"));
        assertThatNoException().isThrownBy(() -> new User("abcde"));
    }
}
