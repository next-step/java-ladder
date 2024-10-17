package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 생성() {
        Player julia = new Player("julia");
        assertThat(julia).isEqualTo(new Player("julia"));
    }

    @Test
    void 이름이_5글자가_넘으면_Exception이_발생한다() {
        assertThatThrownBy(() -> new Player("testtest"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("name is too long");
    }
}
