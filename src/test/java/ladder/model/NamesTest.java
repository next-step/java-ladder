package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @DisplayName("이름이 생성된다.")
    @Test
    void create() {
        Names names = new Names("a,b,c");
        assertThat(names.getNames()).containsExactly(new Name("a"), new Name("b"), new Name("c"));
    }

    @DisplayName("이름이 중복되면 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> {
            new Names("a,a,b");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
