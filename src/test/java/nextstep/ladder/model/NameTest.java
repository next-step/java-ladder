package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("이름은 5자를 넘길 수 없다")
    public void length() {
        assertThatThrownBy(() -> {
            new Name("123456");
        })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 equals 테스트")
    public void equals() {
        assertThat(new Name("osw")).isEqualTo(new Name("osw"));
    }
}