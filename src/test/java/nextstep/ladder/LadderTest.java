package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    Ladder ladder;
    Result result;

    @BeforeEach
    void init() {
        Point point = Point.init(false); // (false,false)
        Point point1 = Point.init(true); // (false,true)
        Point point2 = Point.init(true).next(true); //(true,false)
        LadderLine line = new LadderLine(Arrays.asList(point, point1, point2));
        Point point3 = Point.init(true);// (false,true);
        Point point4 = Point.init(true).next(false);// (true, false);
        Point point5 = Point.init(false);
        LadderLine line1 = new LadderLine(Arrays.asList(point3, point4, point5));
        Point point6 = Point.init(false);// (false,false);
        Point point7 = Point.init(true); // (false,true)
        Point point8 = Point.init(true).next(true); //(true,false)
        LadderLine line2 = new LadderLine(Arrays.asList(point6, point7, point8));
        ladder = new Ladder(Arrays.asList(line,line1,line2));
        result = new Result(Arrays.asList("꽝", "1등", "2등"));
    }

    @Test
    @DisplayName("입력 받은 참여자와 사다리 높이에 해당하는 Ladder를 생성한다.")
    void create() {
        assertThat(new Ladder(5, 5).size()).isEqualTo(5);
    }

    @Test
    void search() {
        int index = ladder.search(0);
        assertThat(result.get(index)).isEqualTo("2등");
    }

    @Test
    void search2() {
        int index = ladder.search(1);
        assertThat(result.get(index)).isEqualTo("1등");
    }

    @Test
    void search3() {
        int index = ladder.search(2);
        assertThat(result.get(index)).isEqualTo("꽝");
    }
}