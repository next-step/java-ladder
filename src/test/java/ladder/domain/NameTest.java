package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("5자를 초과하는 값을 할당하는 경우 Name 객체를 생성하는데 실패한다.")
    void create() {
        assertThatThrownBy(() -> new Name("scappy")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("5자 이하의 이름만 입력 가능합니다.");
    }
}