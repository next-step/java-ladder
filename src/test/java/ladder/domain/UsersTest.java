package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UsersTest {

    @Test
    @DisplayName("유저가 1명일때 IllegalArgumentException 이 발생한다.")
    void notCreateUsersTest() {

        //given
        String[] userNames = "asdf".split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Users.from(userNames));
    }
}
