package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void equalsHorizontal() {
        assertThat(new Point(Direction.HORIZONTAL).equalsHorizontal()).isTrue();
        assertThat(new Point(Direction.VERTICAL).equalsHorizontal()).isFalse();
    }

    @Test
    void addIndent() {
        assertThat(new Point(Direction.VERTICAL).addIndent()).isEqualTo("|");
        assertThat(new Point(Direction.HORIZONTAL).addIndent()).isEqualTo("-----");
        assertThat(new Point(Direction.NONE).addIndent()).isEqualTo("     ");
    }
}
