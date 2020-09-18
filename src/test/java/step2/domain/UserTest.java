package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("유저의 이름 길이 유효성 체크")
    void nameLengthCheck() {
        assertThrows(IllegalArgumentException.class, () -> User.of("test12"));
    }
}

