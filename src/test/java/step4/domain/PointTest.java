package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void 지점을_생성한다() {
        //given
        Point point = Point.of(Position.of(0), Direction.of(false, true));
        //when & then
        assertThat(point).isEqualTo(Point.of(Position.of(0), Direction.of(false, true)));
    }

    @Test
    void 시작_지점을_생성한다() {
        //given
        Point point = Point.start(Boolean.TRUE);
        //when & then
        assertThat(point.position()).isEqualTo(0);
    }

    @Test
    void 시작_다음_지점을_생성한다() {
        //given
        Point point = Point.start(Boolean.FALSE).next(Boolean.TRUE);
        //when & then
        assertThat(point.position()).isEqualTo(1);
    }

    @Test
    void 마지막_지점을_생성한다() {
        //given
        Point point = Point.start(Boolean.FALSE).next(Boolean.TRUE).last();
        //when & then
        assertThat(point.position()).isEqualTo(2);
    }

    @Test
    void 지점을_오른쪽으로_이동한다() {
        //given
        Point point = Point.of(Position.of(0), Direction.of(false, true));
        //when
        point.move();
        //then
        assertThat(point.position()).isEqualTo(1);
    }

    @Test
    void 지점을_왼쪽으로_이동한다() {
        //given
        Point point = Point.of(Position.of(1), Direction.of(true, false));
        //when
        point.move();
        //then
        assertThat(point.position()).isEqualTo(0);
    }

    @Test
    void 지점이_이동하지_않는다() {
        //given
        Point point = Point.of(Position.of(1), Direction.of(false, false));
        //when
        point.move();
        //then
        assertThat(point.position()).isEqualTo(1);
    }
}
