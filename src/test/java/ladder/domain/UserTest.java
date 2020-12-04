package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("참여자 이름 길이가 최소 1자 ~ 5자에 충족하지 못할 경우 IllegalArgumentException 발생")
    void user_nameIsBlank_throwIllegalArgumentException() {
        assertThatThrownBy(() -> User.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 최소 1자 ~ 5자까지 입력");
    }

    @Test
    @DisplayName("참여자 이름 길이가 최소 1자 ~ 5자에 충족하지 못할 경우 IllegalArgumentException 발생")
    void user_nameLengthOver_throwIllegalArgumentException() {
        assertThatThrownBy(() -> User.of("devyoon91"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 최소 1자 ~ 5자까지 입력");
    }
}
