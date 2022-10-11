package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step1.domain.UserName;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 비어있으면 에러")
    void validateUserName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }

    @Test
    @DisplayName("이름이 5글자 넘을 시 에러")
    void validateUserName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName("5글자넘어요"));
    }
}