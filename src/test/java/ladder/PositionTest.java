package ladder;

import ladder.domain.Position;
import ladder.domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("현재 위치가 참이면 위치가 증가한다")
    public void position_foward() {
        Row row = new Row(Arrays.asList(false, true, false));
        Position position = new Position(1);
        assertThat(position.moved(row)).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("현재 위치가 거짓이며, 이전 위치가 참이면 위치가 감소한다")
    public void position_backward() {
        Row row = new Row(Arrays.asList(false, true, false));
        Position position = new Position(2);
        assertThat(position.moved(row)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("현재 위치가 거짓이며, 이전 위치가 거짓이면 위치는 변하지 않는다")
    public void position_not_move() {
        Row row = new Row(Arrays.asList(true, false, false));
        Position position = new Position(3);
        assertThat(position.moved(row)).isEqualTo(new Position(3));
    }

}
