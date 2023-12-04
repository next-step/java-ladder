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

    @Test
    @DisplayName("시작점을 생성한다. 왼쪽으로는 이동이 불가능하다.")
    public void create_first(){
        assertThat(Point.first(true).move()).isEqualTo(Direction.RIGHT);
        assertThat(Point.first(false).move()).isEqualTo(Direction.DOWN);
    }

    @Test
    @DisplayName("종료점을 생성한다. 오른쪽으로는 이동이 불가능하다.")
    public void create_last(){
        assertThat(Point.last(true).move()).isEqualTo(Direction.LEFT);
        assertThat(Point.last(false).move()).isEqualTo(Direction.DOWN);
    }
}
