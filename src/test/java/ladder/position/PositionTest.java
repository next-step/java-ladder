package ladder.position;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void create() {
        // given
        Position self = Position.of(2);

        // when
        Position other = Position.of(2);

        // then
        assertThat(self).isSameAs(other);
    }
}
