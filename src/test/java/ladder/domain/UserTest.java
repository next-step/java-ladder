package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 이름_5글자_초과() {
        assertThatThrownBy(() -> new User("123456")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

}
