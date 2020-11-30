package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @Test
    @DisplayName("참여자 이름을 받지 못할 경우 IllegalArgumentException 발생")
    void user_nameLengthCheck_throwIllegalArgumentException() {
        assertThatThrownBy(() -> {
            Users.of(null);
            Users.of("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름을 입력해야 합니다");
    }
}
