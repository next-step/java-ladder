package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @Test
    @DisplayName("참여자 이름이 공백일 경우 IllegalArgumentException 발생")
    void user_empty_throwIllegalArgumentException() {
        assertThatThrownBy(() -> Users.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름을 입력해야 합니다");
    }

    @Test
    @DisplayName("참여자 이름이 Null 일경우 IllegalArgumentException 발생")
    void user_null_throwIllegalArgumentException() {
        assertThatThrownBy(() -> Users.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름을 입력해야 합니다");
    }
}
