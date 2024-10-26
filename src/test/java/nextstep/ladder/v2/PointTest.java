package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Direction;
import nextstep.ladder.v2.model.Point;
import nextstep.ladder.v2.model.PointGenerator;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("point class 생성 - down")
    void createPointDownTest() {
        //given

        //when
        Point point = new Point(false, false);

        //then
        Assertions.assertThat(point.getDirection()).isEqualTo(Direction.DOWN);
    }

    @Test
    @DisplayName("point class 생성 - left")
    void createPointLeftTest() {
        //given

        //when
        Point point = new Point(true, false);

        //then
        Assertions.assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("point class 생성 - right")
    void createPointRightTest() {
        //given

        //when
        Point point = new Point(false, true);

        //then
        Assertions.assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("point class 생성 - illegal direction")
    void createPointTest_IllegalDirection() {
        //given

        //when
        ThrowableAssert.ThrowingCallable callable = () -> new Point(true, true);

        //then
        Assertions.assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시작 point 생성")
    void createFirstPointTest() {
        //given

        //when
        Point point = Point.first(true);
        //then
        Assertions.assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("point next")
    void pointNextTest() {
        //given
        PointGenerator pointGenerator = new MockPointGenerator();

        //when
        Point point = Point.first(true).next(pointGenerator);

        //then
        Assertions.assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
    }
}
