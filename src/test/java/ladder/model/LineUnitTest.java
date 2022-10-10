package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineUnitTest {

    @Test
    void shouldAddNext() {
        LineUnit unitA = new LineUnit();
        LineUnit unitB = new LineUnit();

        unitA.addNext(unitB);

        assertThat(unitB.hasPrevious()).isTrue();
        assertThat(unitA.hasNext()).isTrue();
    }

    @Test
    void shouldNotAddNext() {
        LineUnit unitA = new LineUnit();
        LineUnit unitB = new LineUnit();

        unitA.addNext(unitB);

        assertThrows(IllegalArgumentException.class, () -> unitA.addNext(new LineUnit()));
    }

    @Test
    void shouldReturnWhetherUnitCanAdd() {
        LineUnit unitA = new LineUnit();
        LineUnit unitB = new LineUnit();

        assertThat(unitA.canAddNext()).isTrue();

        unitA.addNext(unitB);

        assertThat(unitA.canAddNext()).isFalse();
    }
}
