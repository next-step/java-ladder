package step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Cross;
import step4.domain.Direction;

public class CrossTest {
    @Test
    public void init() {
        assertThat(Cross.of(true, false)).isEqualTo(Cross.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Cross.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 타기 첫번째 lane에서 이동가지가 오른쪽에 존재한다면, 이동할 방향은 오른쪽이다.")
    @Test
    public void first() {
        Cross first = Cross.first(true);
        assertThat(first.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리 타기 첫번째 lane에서 이동가지가 존재하지 않는다면, 이동할 방향은 아래쪽이다.")
    @Test
    public void first2() {
        Cross first = Cross.first(false);
        assertThat(first.move()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("사다리 타기 마지막 lane에서 이동가지가 왼쪽에 존재한다면, 이동할 방향은 왼쪽이다.")
    @Test
    public void last() {
        Cross last = Cross.first(true).last();
        assertThat(last.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 왼쪽에 가지가 존재한다면, 이동할 방향은 왼쪽이다.")
    @Test
    public void next() {
        Cross next = Cross.next(true, false);
        assertThat(next.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 오른쪽에 가지가 존재한다면, 이동할 방향은 오른쪽이다.")
    @Test
    public void nex2() {
        Cross next = Cross.next(false, true);
        assertThat(next.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 가지가 존재하지 않는다면, 이동할 방향은 아래쪽이다.")
    @Test
    public void next3() {
        Cross next = Cross.next(false, false);
        assertThat(next.move()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 가지가 왼쪽에 존재한다면, 이동할 방향은 왼쪽이다.")
    @Test
    public void type2_next() {
        Cross cross = Cross.first(true).next(false);
        assertThat(cross.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 가지가 오른쪽에 존재한다면, 이동할 방향은 오른쪽이다.")
    @Test
    public void type2_next2() {
        Cross cross = Cross.first(false).next(true);
        assertThat(cross.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리 타기에서 첫번 째 혹은 마지막이 아닌 중간 lane에서, 가지가 존재하지 않는다면, 이동할 방향은 아래쪽이다.")
    @Test
    public void type2_next3() {
        Cross cross = Cross.first(false).next(false);
        assertThat(cross.move()).isEqualTo(Direction.DOWN);
    }
}
