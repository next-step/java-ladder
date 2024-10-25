package ladder2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 참가자_이름은_5글자_이하다() {
        assertThatThrownBy(() -> new Player("tttttt"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
