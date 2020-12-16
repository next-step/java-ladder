package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    void create() {
        assertThat(Name.create("aaa")).isEqualTo(Name.create("aaa"));
    }

    @Test
    @DisplayName(value = "이름에 null 또는 공백 입력시 IllegalArgumentException 발생")
    void isBlank_IllegalArgumentException() {
        assertThatThrownBy(() -> Name.create(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "이름이 5글자를 초과하면 IllegalArgumentException 발생")
    void isOverLengthName__IllegalArgumentException() {
        assertThatThrownBy(() -> Name.create("abcdaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
