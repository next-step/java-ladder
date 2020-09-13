package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("default 생성 테스트")
    public void createDefault(){
        Point point = new Point();

        assertThat(point.getDirection().equals(Direction.STOP));
    }

    @Test
    void getDirection() {
        Point prevPoint = new Point();
        Point point = new Point(prevPoint);

        assertThat(point.getDirection().equals(Direction.RIGTH));
    }
}