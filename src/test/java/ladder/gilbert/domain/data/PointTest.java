package ladder.gilbert.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void equalsHorizontal() {
        assertThat(new Point(Direction.HORIZONTAL).equalsHorizontal()).isTrue();
        assertThat(new Point(Direction.VERTICAL).equalsHorizontal()).isFalse();
    }

    @Test
    void formatted() {
        assertThat(new Point(Direction.VERTICAL).formatted()).isEqualTo("|");
        assertThat(new Point(Direction.HORIZONTAL).formatted()).isEqualTo("-----");
        assertThat(new Point(Direction.NONE).formatted()).isEqualTo("     ");
    }
}
