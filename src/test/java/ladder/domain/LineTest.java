package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class LineTest {

    @Test
    public void 라인이_겹치는_경우_테스트() {
        boolean result = Line.isOverLapped(true, true);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 라인이_안겹치는_경우_테스트() {
        boolean result = Line.isOverLapped(false, true);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 사다리_가장_왼쪽플레이어_움직임_테스트() {
        Line oneLine = new Line(Arrays.asList(true, false, true));
        int result = oneLine.moveToNextPoint(0);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 사다리_가장_오른쪽플레이어_움직임_테스트1() {
        Line oneLine = new Line(Arrays.asList(true, false, true));
        int result = oneLine.moveToNextPoint(3);

        assertThat(result).isEqualTo(2);
    }
}