package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

    @Test
    void shouldAddNext() {
        Direction unitA = new Direction();
        Direction unitB = new Direction();

        unitA.addNext(unitB);

        assertThat(unitB.hasPrevious()).isTrue();
        assertThat(unitA.hasNext()).isTrue();
    }

    @Test
    void shouldNotAddNext() {
        Direction unitA = new Direction();
        Direction unitB = new Direction();

        unitA.addNext(unitB);

        assertThrows(IllegalArgumentException.class, () -> unitA.addNext(new Direction()));
    }

    @Test
    void shouldReturnWhetherUnitCanAdd() {
        Direction unitA = new Direction();
        Direction unitB = new Direction();

        assertThat(unitA.canAddNext()).isTrue();

        unitA.addNext(unitB);

        assertThat(unitA.canAddNext()).isFalse();
    }
}
