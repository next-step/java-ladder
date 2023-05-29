package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.ResultView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @DisplayName("이름은 5글자를 넘길 수 없다.")
    @Test
    public void nameLengthTest() {
        assertThatThrownBy(() -> new Name("테스트이름입니다."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 빈값일 수 없다.")
    @Test
    public void nameBlankTest() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 all(= ${ResultView.ALL}) 일수 없다.")
    @Test
    public void nameExcludingTest() {
        assertThatThrownBy(() -> new Name(ResultView.ALL))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
