package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    void Player은_이름_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Player((Name) null)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
