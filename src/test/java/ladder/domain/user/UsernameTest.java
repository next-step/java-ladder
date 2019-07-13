package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsernameTest {

    @Test
    @DisplayName("사용자 이름을 정상적으로 생성하는지 확인한다")
    void create() {
        Username username = Username.of("john");
        assertThat(username.getUsername()).isEqualTo("john");
        assertThat(username.length()).isEqualTo(4);
    }

    @Test
    @DisplayName("모든 사용자 여부 판단을 확인한다")
    void checkAllUser() {
        Username username = Username.of("all");
        assertTrue(username.isAllUser());
    }

    @Test
    @DisplayName("잘못된 입력인경우 예외처리를 확인한다")
    void exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Username.of("");
                }).withMessageMatching("Invalid username");
    }
}
