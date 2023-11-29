package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PathPositionTest {

    @Test
    @DisplayName("사다리의 행(row) 이동을 위한 PathPostion을 생성한다. 왼쪽으로 이동가능한 경우 위치값이 1 감소한다.")
    public void move_left() {
        PathPosition pathPosition = PathPosition.of(1, List.of(true, false));
        Position move = pathPosition.move();
        Assertions.assertThat(move).isEqualTo(Position.from(0));
    }

    @Test
    @DisplayName("사다리의 행(row) 이동을 위한 PathPostion을 생성한다. 오른쪽으로 이동가능한 경우 위치값이 1 증가한다.")
    public void move_right() {
        PathPosition pathPosition = PathPosition.of(1, List.of(false, true));
        Position move = pathPosition.move();
        Assertions.assertThat(move).isEqualTo(Position.from(2));
    }


    @Test
    @DisplayName("사다리의 행(row) 이동을 위한 PathPostion을 생성한다. 이동이 불가능한 경우 위치값은 그대로이다.")
    public void move_hold() {
        PathPosition pathPosition = PathPosition.of(1, List.of(false, false));
        Position move = pathPosition.move();
        Assertions.assertThat(move).isEqualTo(Position.from(1));
    }
}
