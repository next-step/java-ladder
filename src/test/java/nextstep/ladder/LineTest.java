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
        Line lineByString_A = Line.ofString("true,false,true,false,false,false");
        Line lineByString_B = Line.ofString("false,false,true,false,true,false");
        Line lineByString_C = Line.ofString("true,false,false,false,true");

        List<Point> line_A = givenA();
        List<Point> line_B = givenB();
        List<Point> line_C = givenC();

        for (int index = 0; index < lineByString_A.getPoints().size(); index++) {
            assertThat(lineByString_A.getPoints().get(index)).isEqualTo(line_A.get(index));
        }
        for (int index = 0; index < lineByString_B.getPoints().size(); index++) {
            assertThat(lineByString_B.getPoints().get(index)).isEqualTo(line_B.get(index));
        }
        for (int index = 0; index < lineByString_C.getPoints().size(); index++) {
            assertThat(lineByString_C.getPoints().get(index)).isEqualTo(line_C.get(index));
        }
    }

    @Test
    @DisplayName("ofString 메소드 인풋으로, Boolean 변환이 불가능한 문자열이 들어왔을 때 'Boolean 으로 변환될 수 없습니다.' 를 반환")
    public void checkCanBeBooleanTest() {
        assertThatThrownBy(() -> {
            Line.ofString("test,test,test");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Boolean 으로 변환될 수 없습니다.");
    }
}
