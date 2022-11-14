package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {

    @DisplayName("이름이 생성된다.")
    @Test
    void create() {
        Users users = new Users("a,b,c");
        assertThat(users.getUsers()).containsExactly(new User("a"), new User("b"), new User("c"));
    }

    @DisplayName("이름이 중복되면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> {
            new Users("a,a,b");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
