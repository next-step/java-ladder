package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void 플레이어의_현재_위치를_생성한다() {
        int currentPosition = 1;
        Position position = Position.from(currentPosition);

        assertThat(position.isSameWith(1)).isTrue();
    }
}
