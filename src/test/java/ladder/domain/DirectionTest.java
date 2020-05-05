package ladder.domain;


import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {
    @Test
    public void RIGHT_next_RIGHT_throwIllegalStateException() {
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(
                () -> RIGHT.next(true)
        );
    }

    @Test
    public void RIGHT_next_LEFT() {
        Direction next = RIGHT.next();

        assertThat(next).isEqualTo(LEFT);
    }

    @Test
    public void LEFT_next_not_LEFT() {
        Direction next = LEFT.next();

        assertThat(next).isNotEqualTo(LEFT);
    }

    @Test
    public void STAY_next_not_LEFT() {
        Direction next = STAY.next();

        assertThat(next).isNotEqualTo(LEFT);
    }
}
