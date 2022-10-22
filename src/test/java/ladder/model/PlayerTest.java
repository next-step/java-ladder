package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    public void 플레이어_이름_5자_초과_오류_검증() {
        assertThatThrownBy(() -> new Player("bellas"))
                .isInstanceOf(RuntimeException.class);
    }

}