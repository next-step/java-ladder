package ladder2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("왼쪽으로 이동한다.")
    public void left(){
        assertThat(Point.of(true, false).move()). isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("오른쪽으로 이동한다.")
    public void right(){
        assertThat(Point.of(false, true).move()). isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("아래로 이동한다.")
    public void down(){
        assertThat(Point.of(false, false).move()). isEqualTo(Direction.DOWN);
    }
}
