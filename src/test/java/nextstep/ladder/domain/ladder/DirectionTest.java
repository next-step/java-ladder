package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("처음 사다리를 시작할 땐 앞에 이어질 방향이 없기 때문에 NONE 아니면, LEFT이다.")
    public void init() {
        Direction right = Direction.first(TRUE);
        Direction none = Direction.first(FALSE);
        assertThat(right).isEqualTo(Direction.RIGHT);
        assertThat(none).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("오른쪽으로 이동하면서 같은 줄에 있는 다음 사다리 방향을 정한다.\n " +
            "현재 사다리 방향이 RIGHT라면 사다리가 이어져야하기 때문에 다음 사다리 방향은 LEFT이다.")
    public void nowRightDirection() {
        Direction next = Direction.RIGHT.next();
        assertThat(next).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("오른쪽으로 이동하면서 같은 줄에 있는 다음 사다리 방향을 정한다.\n " +
            "현재 사다리 방향이 LEFT라면 그 다음 사다리는 이어지지 않아야하기 때문에 RIGHT아니면 NONE이다.")
    public void nowLeftDirection() {
        for (int i = 0; i < 100; i++) {
            Direction next = Direction.LEFT.next();
            assertThat(next).isNotEqualTo(Direction.LEFT);
        }
    }

    @Test
    @DisplayName("오른쪽으로 이동하면서 같은 줄에 있는 다음 사다리 방향을 정한다.\n " +
            "현재 사다리 방향이 NONE라면 그 다음 사다리는 이어지지 않아야하기 때문에 RIGHT아니면 NONE이다.")
    public void nowNoneDirection() {
        for (int i = 0; i < 100; i++) {
            Direction next = Direction.NONE.next();
            assertThat(next).isNotEqualTo(Direction.LEFT);
        }
    }

    @Test
    @DisplayName("다음 사다리가 마지막 사다리라면 다음 사다리 방향은 끝나야 한다. \n" +
            "현재 사다리 방향이 RIGHT라면 사다리가 이어져야하기 때문에 다음 사다리 방향은 LEFT이다.")
    public void lastNowRightDirection() {
        Direction last = Direction.RIGHT.last();
        assertThat(last).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("다음 사다리가 마지막 사다리라면 다음 사다리 방향은 끝나야 한다. \n" +
            "현재 사다리 방향이 LEFT이라면 사다리가 이어지지 않아야하기 때문에 다음 사다리 방향은 NONE이다.")
    public void lastNowLeftDirection() {
        Direction last = Direction.LEFT.last();
        assertThat(last).isEqualTo(Direction.NONE);
    }

    @Test
    @DisplayName("다음 사다리가 마지막 사다리라면 다음 사다리 방향은 끝나야 한다. \n" +
            "현재 사다리 방향이 NONE이라면 사다리가 이어지지 않아야하기 때문에 다음 사다리 방향은 NONE이다.")
    public void lastNowNoneDirection() {
        Direction last = Direction.NONE.last();
        assertThat(last).isEqualTo(Direction.NONE);
    }
}