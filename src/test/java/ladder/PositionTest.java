package ladder;

import ladder.domain.Position;
import ladder.domain.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("현재 발판이 놓여 있는 경우 오른쪽으로 이동한다")
    public void position_foward() {
        Row row = new Row(Arrays.asList(false, true, false));
        Position position = new Position(1);
        assertThat(position.moved(row)).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("현재 발판이 놓여 있지 않으며, 뒤쪽 발판이 놓여 있는 경우 왼쪽으로 이동한다")
    public void position_backward() {
        Row row = new Row(Arrays.asList(false, true, false));
        Position position = new Position(2);
        assertThat(position.moved(row)).isEqualTo(new Position(1));
    }

}
