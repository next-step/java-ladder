package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserTest {

    @Test
    @DisplayName("사람의 이름이 5글자를 초과할때 IllegalArgumentException 이 발생한다")
    void notCreateUserTest() {

        //given
        String userName = "asdfgh";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> User.from(userName));
    }
}
