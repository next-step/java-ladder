package nextstep.laddar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void create() {
        User name = new User("박윤환");
        assertThat(name).extracting("name").isEqualTo("박윤환");
    }

    @Test
    void overSize() {
        assertThatThrownBy(() -> new User("다섯글자이상"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자를 넘을 수 없습니다.");
    }
}