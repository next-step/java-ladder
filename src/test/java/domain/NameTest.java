package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("사람의 이름은 5글자까지만 가능하다.")
    @Test
    void test() {
        assertThatThrownBy(() -> new Name("Jackson"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }
}
