package step4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.domain.UserName;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void validateUserNameIsEmpty(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }

    @Test
    void validateUserNameLengthCheck() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName("5글자넘음+"));
    }
}