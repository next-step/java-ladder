package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    @DisplayName("사다리는 참여자 수와 높이에 따라 생성된다.")
    void 사다리_생성(){
        List<Point> points = Arrays.asList(new Point(Direction.RIGHT),new Point(Direction.LEFT),new Point(Direction.STRAIGHT));
        FixDirectionStrategy strategy = new FixDirectionStrategy();

        Ladder ladder = LadderFactory.from(new Names("name,pobi,meme"),new Height(2),strategy);
        assertThat(ladder.ladder())
            .isEqualTo(Arrays.asList(new Line(points),new Line(points)));
    }
}
