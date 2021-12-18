package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("ofString 메소드로 Line 이 잘 만들어지는지 테스트")
    public void LineFromStringInputTest() {
        Line lineByStringA = Line.ofString("right,left,right,left,none,none");
        Line lineByStringB = Line.ofString("none,right,left,right,left,none");
        Line lineByStringC = Line.ofString("right,left,none,right,left");

        List<Point> lineA = new ArrayList<>();
        lineA.add(Point.of(new Direction("right"), 0));
        lineA.add(Point.of(new Direction("left"), 1));
        lineA.add(Point.of(new Direction("right"), 2));
        lineA.add(Point.of(new Direction("left"), 3));
        lineA.add(Point.of(new Direction("none"), 4));
        lineA.add(Point.of(new Direction("none"), 5));

        List<Point> lineB = new ArrayList<>();
        lineB.add(Point.of(new Direction("none"), 0));
        lineB.add(Point.of(new Direction("right"), 1));
        lineB.add(Point.of(new Direction("left"), 2));
        lineB.add(Point.of(new Direction("right"), 3));
        lineB.add(Point.of(new Direction("left"), 4));
        lineB.add(Point.of(new Direction("none"), 5));

        List<Point> lineC = new ArrayList<>();
        lineC.add(Point.of(new Direction("right"), 0));
        lineC.add(Point.of(new Direction("left"), 1));
        lineC.add(Point.of(new Direction("none"), 2));
        lineC.add(Point.of(new Direction("right"), 3));
        lineC.add(Point.of(new Direction("left"), 4));

        assertThat(lineByStringA.getPoints()).isEqualTo(lineA);
        assertThat(lineByStringB.getPoints()).isEqualTo(lineB);
        assertThat(lineByStringC.getPoints()).isEqualTo(lineC);
    }

    @Test
    @DisplayName("ofString 메소드 인풋으로, Point로 변환이 불가능한 문자열이 들어왔을 때 'Boolean 으로 변환될 수 없습니다.' 를 반환")
    public void checkCanBeBooleanTest() {
        assertThatThrownBy(() -> {
            Line.ofString("test,test,test");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Point 로 변환될 수 없습니다.");
    }

    @Test
    @DisplayName("move 메소드 호출 시 index를 input으로 넣어주면 move한 index를 반환")
    public void moveTest() {
        Line line = Line.ofString("right,left,right,left,none,none");
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(4)).isEqualTo(4);
        assertThat(line.move(3)).isEqualTo(2);
        assertThat(line.move(5)).isEqualTo(5);
    }
}
