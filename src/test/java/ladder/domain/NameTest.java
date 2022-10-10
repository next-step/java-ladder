package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름이 5자 초과면 Name 생성 실패")
    @Test
    void create_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("chicken"))
                .withMessage("이름은 5자이하 이어야 합니다");
    }

    @Test
    void length() {
        String name = "apple";
        assertThat(new Name(name).length()).isEqualTo(name.length());
    }
}
