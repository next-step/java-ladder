package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("default 생성 테스트")
    public void createDefaultPointTest(){
        Point point = new Point();

        assertThat(point.getDirection().equals(Direction.STOP));
    }

    @Test
    void createNextPointTest() {
        Point prevPoint = new Point();
        Point point = prevPoint.next();

        assertThat(point.getDirection().equals(Direction.RIGTH));
    }
}