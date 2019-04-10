package ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineMakersTest {

    @Test
    public void 이전포인트가_True면_False() {
        List<Boolean> linePoint = new ArrayList<>();
        linePoint.add(false);
        linePoint.add(true);

        Boolean aBoolean = LadderLineMakers.randomBooleanPoint(linePoint, 2);
        assertThat(aBoolean).isFalse();
    }

    @Test
    public void 플레이어_5명일때_포인트생성_5() {
        List<Boolean> line = LadderLineMakers.createLine(5);
        assertThat(line.size()).isEqualTo(5);
    }

}