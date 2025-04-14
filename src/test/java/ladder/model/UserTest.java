package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {


    @Test
    void 이름_생성() {
        User user = new User("alice");
        assertThat(user.isName("alice")).isTrue();
    }

    @Test
    void 이름_null() {
        assertThatThrownBy(() -> {
            new User(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 이름_빔() {
        assertThatThrownBy(() -> {
            new User("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 이름_공백() {
        assertThatThrownBy(() -> {
            new User("   ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 길이_제한() {
        assertThatThrownBy(() -> {
            new User("ABCDEF");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자를 초과할 수 없습니다.");
    }
}
