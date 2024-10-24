package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerOldTest {

    @Test
    void 생성() {
        PlayerOld julia = new PlayerOld("julia");
        assertThat(julia).isEqualTo(new PlayerOld("julia"));
    }

    @Test
    void 이름이_5글자가_넘으면_Exception이_발생한다() {
        assertThatThrownBy(() -> new PlayerOld("testtest"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("name is too long");
    }
}
