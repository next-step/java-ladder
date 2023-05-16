package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("5글자 이하 유저이름")
    public void createUser() {
        assertThat(new User("users").name()).isEqualTo("users");
    }

    @Test
    @DisplayName("Exception Test 유저이름 5글자 초과하는 경우")
    public void createExceptionUser() {
        assertThatThrownBy(() -> new User("except"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
