package nextstep.ladder.domain.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {
    private DirectionSelector directionSelectorOnlyTrue;
    private DirectionSelector directionSelectorOnlyFalse;

    @BeforeEach
    public void setUp() {
        directionSelectorOnlyTrue = () -> true;
        directionSelectorOnlyFalse = () -> false;
    }

    @Test
    public void init() {
        assertThat(Direction.of(true, false, directionSelectorOnlyTrue))
                .isEqualTo(Direction.of(true, false, directionSelectorOnlyTrue));
    }

    @Test
    public void init_invalid() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> Direction.of(TRUE, TRUE,
                        directionSelectorOnlyTrue));
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.createFirst(directionSelectorOnlyTrue).getNext();
        assertThat(next)
                .isEqualTo(Direction.of(TRUE, FALSE, directionSelectorOnlyTrue));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.createFirst(directionSelectorOnlyFalse).getNext();
        }
    }

    @Test
    public void next_true() {
        Direction next =
                Direction.of(TRUE, FALSE, directionSelectorOnlyTrue).getNext(TRUE);
        assertThat(next)
                .isEqualTo(Direction.of(FALSE, TRUE, directionSelectorOnlyTrue));
    }

    @Test
    public void next_false() {
        Direction next =
                Direction.of(FALSE, TRUE, directionSelectorOnlyTrue).getNext(FALSE);
        assertThat(next)
                .isEqualTo(Direction.of(TRUE, FALSE, directionSelectorOnlyTrue));
    }

    @Test
    public void first() {
        Direction first = Direction.createFirst(directionSelectorOnlyTrue);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.createFirst(directionSelectorOnlyTrue).getLast();
        assertThat(last)
                .isEqualTo(Direction.of(TRUE, FALSE, directionSelectorOnlyTrue));
    }
}