package nextstep.ladder;

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
        lineA.add(Point.of("right"));
        lineA.add(Point.of("left"));
        lineA.add(Point.of("right"));
        lineA.add(Point.of("left"));
        lineA.add(Point.of("none"));
        lineA.add(Point.of("none"));


        List<Point> lineB = new ArrayList<>();
        lineB.add(Point.of("none"));
        lineB.add(Point.of("right"));
        lineB.add(Point.of("left"));
        lineB.add(Point.of("right"));
        lineB.add(Point.of("left"));
        lineB.add(Point.of("none"));

        List<Point> lineC = new ArrayList<>();
        lineC.add(Point.of("right"));
        lineC.add(Point.of("left"));
        lineC.add(Point.of("none"));
        lineC.add(Point.of("right"));
        lineC.add(Point.of("left"));

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
}
