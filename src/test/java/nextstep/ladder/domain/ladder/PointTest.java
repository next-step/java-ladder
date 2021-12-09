package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PointTest {

    @Test
    @DisplayName("현재 포인트의 방향을 고려하여 다음 포인트를 생성할 수 있다.\n" +
            "처음 생성할 때는 Point.first() 을 사용한다.")
    public void pointFirst() {
        assertThat(Point.first(TRUE).getDirection()).isEqualTo(Direction.RIGHT);
        assertThat(Point.first(FALSE).getDirection()).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("현재 포인트의 방향을 고려하여 다음 포인트를 생성할 수 있다.\n" +
            "사다리의 body에 해당하는 포인트를 생성할 때는 Point.next() 를 사용한다.")
    public void pointNext() {
        assertThat(Point.first(TRUE).next().getDirection()).isEqualTo(Direction.LEFT);
        assertThat(Point.first(FALSE).next().getDirection()).isIn(Direction.RIGHT, Direction.NONE);
    }

    @Test
    @DisplayName("현재 포인트의 방향을 고려하여 다음 포인트를 생성할 수 있다.\n" +
            "사다리의 끝에 해당하는 포인트를 생성할 때는 Point.last() 를 사용한다.")
    public void pointLast() {
        assertThat(Point.first(TRUE).last().getDirection()).isEqualTo(Direction.LEFT);
        assertThat(Point.first(FALSE).last().getDirection()).isEqualTo(Direction.NONE);
    }

}