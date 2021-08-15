package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("이름이 5글자 넘어가는경우 예외 발생 테스트")
    void userTest() {
        assertThatThrownBy(() -> new User("aaaaaa")).isInstanceOf(IllegalArgumentException.class);
    }
}
