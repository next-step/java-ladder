package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DirectionTest {

    @DisplayName("위치 테스트")
    @Test
    public void testInit() {
        assertThat(Direction.of(true, false)).isEqualTo((Direction.of(true, false)));
    }

    @DisplayName("연속 TRUE 일때 오류 발생")
    @Test
    void testNotDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> {
            Direction.of(TRUE, TRUE);
        });
    }


    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next();
        assertThat(next).isEqualTo(Direction.of(FALSE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
