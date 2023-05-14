package ladder.domain;

import ladder.exception.IllegalPlayerNameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class PlayerTest {
    @Test
    void 주어진_문자열로_플레이어_이름을_지정하여_플레이어를_생성할_수_있다() {
        assertThat(new Player("abc").getName()).isEqualTo("abc");
    }

    @Test
    void 플레이어_이름이_5자를_넘어갈_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Player("abcdef")).isInstanceOf(IllegalPlayerNameException.class);
    }
}
