package nextstep.ladder;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LadderLineTest {

    @Test
    void create() {
        assertThat(LadderLine.init(5).size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 마지막 라인의 오른쪽에는 가로 선이 올 수 없습니다.")
    void isValidLadderLine() {
        Point init = Point.init(true); //( false ,true)
        Point point = init.next();// ( true , 랜덤);
        Point point1 = point.next(true); //(이전 인덱스 다음 값  , true)
        assertThatThrownBy( ()->
                new LadderLine(Arrays.asList(init,point,point1))).isInstanceOf(IllegalArgumentException.class);
    }
}