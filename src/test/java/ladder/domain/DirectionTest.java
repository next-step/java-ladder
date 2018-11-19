package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private final boolean TRUE = true;
    private final boolean FALSE = false;

    @Test
    public void 옆줄이_있을때_새로운_줄_생성() {
        Direction direction = Direction.of(FALSE, TRUE).isOverlapped();
        assertThat(direction.isRight()).isEqualTo(FALSE);
    }

    @Test
    public void 옆줄이_없을때_새로운_줄_생성() {
        Direction direction = Direction.of(FALSE, FALSE).isOverlapped();
        System.out.println(direction);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 왼쪽_오른쪽_줄이_모두_있는_경우() {
        Direction.of(TRUE, TRUE);
    }
}