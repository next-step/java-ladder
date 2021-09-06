package step2;

import org.junit.jupiter.api.Test;
import step2.model.Point;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @Test
    public void 오른쪽으로_움직여야함() {
        //given
        int index = 0;

        //when
        Point point = new Point(false, true);
        int actual = point.changeIndex(index);

        //then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void 왼쪽으로_움직여야함() {
        //given
        int index = 1;

        //when
        Point point = new Point(true, false);
        int actual = point.changeIndex(index);

        //then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void 아래로_움직여야함() {
        //given
        int index = 0;

        //when
        Point point = new Point(false, false);
        int actual = point.changeIndex(index);

        //then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void 예외발생() {
        //then
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

}
