package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MakePoints {
    List<Point> givenA() {
        List<Point> list = new ArrayList<>();
        list.add(Point.of(true));
        list.add(Point.of(false));
        list.add(Point.of(true));
        list.add(Point.of(false));
        list.add(Point.of(false));
        list.add(Point.of(false));
        return list;
    }

    List<Point> givenB() {
        List<Point> list = new ArrayList<>();
        list.add(Point.of(false));
        list.add(Point.of(false));
        list.add(Point.of(true));
        list.add(Point.of(false));
        list.add(Point.of(true));
        list.add(Point.of(false));
        return list;
    }

    List<Point> givenC() {
        List<Point> list = new ArrayList<>();
        list.add(Point.of(true));
        list.add(Point.of(false));
        list.add(Point.of(false));
        list.add(Point.of(false));
        list.add(Point.of(true));
        return list;
    }
}

public class LineTest extends MakePoints {
    @Test
    @DisplayName("ofString 메소드로 Line 이 잘 만들어지는지 테스트")
    public void LineFromStringInputTest() {
        Line lineByStringA = Line.ofString("true,false,true,false,false,false");
        Line lineByStringB = Line.ofString("false,false,true,false,true,false");
        Line lineByStringC = Line.ofString("true,false,false,false,true");

        List<Point> lineA = givenA();
        List<Point> lineB = givenB();
        List<Point> lineC = givenC();

        assertThat(lineByStringA).isEqualTo(lineA);
        assertThat(lineByStringB).isEqualTo(lineB);
        assertThat(lineByStringC).isEqualTo(lineC);
    }

    @Test
    @DisplayName("ofString 메소드 인풋으로, Boolean 변환이 불가능한 문자열이 들어왔을 때 'Boolean 으로 변환될 수 없습니다.' 를 반환")
    public void checkCanBeBooleanTest() {
        assertThatThrownBy(() -> {
            Line.ofString("test,test,test");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Boolean 으로 변환될 수 없습니다.");
    }
}
