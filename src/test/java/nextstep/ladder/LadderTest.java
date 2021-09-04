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

    private Ladder ladder;
    private LadderLine line;

    @BeforeEach
    void init() {
        Point point1 = Point.init(true); // 0 , (false , true)
        Point point2 = point1.next(false);//  1, (true , false)
        Point point3 = point2.next(false);// 2 , (false, false)
        LadderLine line1 = new LadderLine(Arrays.asList(point1, point2, point3));

        Point point4 = Point.init(false); // 0 , (false, false)
        Point point5 = point4.next(true); // 1, (false, true)
        Point point6 = point5.next(false); // 2, (true ,false)

    }

}