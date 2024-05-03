package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.ladder.Cross;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossTest {
    @Test
    @DisplayName("왼쪽으로 이동하면 위치를 -1만큼 이동한다.")
    void MOVE_LEFT_THEN_POSITION_MINUS(){
        Point left = Point.first(()->true).next(()->false);
        Cross cross = new Cross(1, left);
        assertThat(cross.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동하면 위치를 +1만큼 이동한다")
    void MOVE_RIGHT_THEN_POSITION_PLUS(){
        Point right = Point.first(()->true);
        Cross cross = new Cross(1, right);
        assertThat(cross.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("연결되어있지 않다면 위치를 이동하지 않는다.")
    void NOT_CONNECTED_THEN_CHANGE_NOTHING(){
        Point pass = Point.first(()->false).next(()->false);
        Cross cross = new Cross(1, pass);
        assertThat(cross.move()).isEqualTo(1);
    }

}
