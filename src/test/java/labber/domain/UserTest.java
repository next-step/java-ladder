package labber.domain;

import labber.exception.UserNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @ParameterizedTest
    @DisplayName("User 이름 예외 테스트")
    @ValueSource(strings = {"overFive", ""})
    void UserNameException(String name) {
        assertThatThrownBy(() -> new User(name)).isInstanceOf(UserNameLengthException.class);
    }

}