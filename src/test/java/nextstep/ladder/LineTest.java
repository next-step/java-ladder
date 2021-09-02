package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("참여자의 수에 맞는 사다리 라인 생성")
    void create() {
        assertThat(new Line(5).size()).isEqualTo(5);
    }


    @Test
    @DisplayName("사다리 마지막 참여자의 Line 오른쪽은 빈값이어야 한다.")
    void isValidLadder() {
        Point point1 = Point.init(true);  //(false,true)
        Point point2 = Point.init(false); //(false,false)
        Point point3 = Point.init(true).insert(false).insert(true); //(false,true)
        assertThatThrownBy(
                () -> new Line(Arrays.asList(point1, point2, point3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 마지막 참여자의 Line 오른쪽은 빈값이어야 한다.")
    void isValidLadder2() {
        Point point1 = Point.init(true);  //(false,true)
        Point point2 = Point.init(false); //(false,false)
        Point point3 = Point.init(true).insert(false).insert(false); //(false,false)
        assertDoesNotThrow(
                () -> new Line(Arrays.asList(point1, point2, point3)));
    }

    @Test
    void search() {
        Point point1 = Point.init(true);  //(false,true)
        Point point2 = Point.init(true).insert(false); //(true,false)
        Point point3 = Point.init(true).insert(false).insert(true); //(false,true)
        Point point4 = Point.init(true).insert(false).insert(false); //(false,true)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(2)).isEqualTo(3);
    }

    @Test
    void search2() {
        Point point1 = Point.init(true);  //(false,true)
        Point point2 = Point.init(false); //(false,true)
        Point point3 = Point.init(true).insert(false); //(true,false)
        Point point4 = Point.init(true).insert(true); //(true,false)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(0)).isEqualTo(1);
    }

    @Test
    void search3() {
        Point point1 = Point.init(false);  //(false,false)
        Point point2 = Point.init(false); //(false,true)
        Point point3 = Point.init(true).insert(false); //(true,false)
        Point point4 = Point.init(true).insert(true); //(true,false)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(0)).isEqualTo(0);
    }

    @Test
    void search4() {
        Point point1 = Point.init(false);  //(false,false)
        Point point2 = Point.init(false); //(false,true)
        Point point3 = Point.init(true).insert(false); //(true,false)
        Point point4 = Point.init(true).insert(true); //(true,false)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(1)).isEqualTo(1);
    }

    @Test
    void search5() {
        Point point1 = Point.init(false);  //(false,false)
        Point point2 = Point.init(false); //(false,true)
        Point point3 = Point.init(true).insert(false); //(true,false)
        Point point4 = Point.init(true).insert(true); //(true,false)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(2)).isEqualTo(1);
    }

    @Test
    void search6() {
        Point point1 = Point.init(false);  //(false,false)
        Point point2 = Point.init(false); //(false,true)
        Point point3 = Point.init(true).insert(false); //(true,false)
        Point point4 = Point.init(true).insert(true); //(true,false)
        Line line = new Line(Arrays.asList(point1, point2, point3 ,point4));
        assertThat(line.search(3)).isEqualTo(2);
    }

}