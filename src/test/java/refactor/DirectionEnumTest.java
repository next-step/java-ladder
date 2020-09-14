package refactor;


import org.junit.jupiter.api.Test;
import refactor.domain.DirectionEnum;
import refactor.domain.DirectionEnum;
import refactor.domain.pointGenerate.PointStrategy;
import refactor.domain.pointGenerate.RandomPoint;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionEnumTest {

    private PointStrategy pointStrategy = new RandomPoint();

    @Test
    public void init() {
        assertThat(DirectionEnum.valueOf(true, false)).isEqualTo(DirectionEnum.valueOf(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> {
            DirectionEnum.valueOf(TRUE, TRUE);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void next_random_true() {
        DirectionEnum next = DirectionEnum.first(TRUE).next(pointStrategy);
        assertThat(next).isEqualTo(DirectionEnum.valueOf(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            DirectionEnum.first(FALSE).next(pointStrategy);
        }
    }

    @Test
    public void next_true() {
        DirectionEnum next = DirectionEnum.valueOf(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(DirectionEnum.valueOf(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        DirectionEnum next = DirectionEnum.valueOf(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(DirectionEnum.valueOf(TRUE, FALSE));
    }

    @Test
    public void first() {
        DirectionEnum first = DirectionEnum.first(TRUE);
        assertThat(first).isEqualTo(DirectionEnum.RIGTH);
    }

    @Test
    public void last() {
        DirectionEnum last = DirectionEnum.first(TRUE).last();
        assertThat(last).isEqualTo(DirectionEnum.valueOf(TRUE, FALSE));
    }
}