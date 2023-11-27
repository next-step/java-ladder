package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {
    @DisplayName("이름 최대길이 초과 시 예외 발생")
    @Test
    void 이름_길이_검증() {
        assertThatThrownBy(() -> new Name("pilming"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

}