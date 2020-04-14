package ladder.domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void lenthValidatorTest() {
        assertThatThrownBy(() -> new User("jonathan"))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }
}
