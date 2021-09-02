package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class PointTest {

    @Test
    public void 첫위치의_Point를_초기화_할_수_있다() {
        //given
        //when
        Point point = Point.start(Direction.start(() -> true));
        //then
        assertThat(point).isEqualTo(Point.start(Direction.start(() -> true)));
    }

    @Test
    public void 다음위치의_Point를_초기화_할_수_있다() {
        //given
        //when
        Point point = Point.start(Direction.start(() -> true)).next();
        //then
        assertThat(point).isEqualTo(Point.create(1, Direction.create(true, false)));
    }

    @Test
    public void 마지막위치의_Point를_초기화_할_수_있다() {
        //given
        //when
        Point point = Point.create(1, Direction.create(false, true)).end();
        //then
        assertThat(point).isEqualTo(Point.create(2, Direction.create(true, false)));
    }

    @Test
    public void 현재_위치에서_움직일_수_있다(){
        //given
        Point point = Point.create(1, Direction.create(true, false));
        //when
        int index = point.move();
        //then
        assertThat(index).isEqualTo(0);
    }
}
