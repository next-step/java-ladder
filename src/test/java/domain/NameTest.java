package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("사람의 이름은 5글자까지만 가능하다.")
    @Test
    void test() {
        Assertions.assertThatThrownBy(() -> new Name("Jackson"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }
}
