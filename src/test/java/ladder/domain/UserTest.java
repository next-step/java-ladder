package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    @DisplayName("이름 확인")
    void name() {
        // given
        String name = "pobi";
        User user = new User(name);

        // when
        String actual = user.getName();

        // then
        assertThat(actual).isEqualTo(name);
    }

    @Test
    @DisplayName("User 이름 - null")
    void nameException() {
        // when
        assertThatThrownBy(() -> {
            new User(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 입력되지 않았습니다.");
        assertThatThrownBy(() -> {
            new User("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("User 이름 - 5글자 초과")
    void nameException2() {
        // when
        assertThatThrownBy(() -> {
            new User("abcdef");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }
}