package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PointTest {

    @Test
    public void 첫다리_생성() {
        Point result = Point.first(false);
        Assertions.assertThat(result).isEqualTo(new Point(false, false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 다리_생성_실패() {
        Point result = new Point(true, true);
        result.validation();
    }

    @Test
    public void 막다리_생성() {
        Point result = Point.last(false);
        Assertions.assertThat(result).isEqualTo(new Point(false, false));
    }

    @Test
    public void 앞다리_확인() {
        Point result = Point.first(false).next(true);
        Assertions.assertThat(result).isEqualTo(new Point(false, true));
    }

    @Test
    public void 앞다리_true() {
        Point result = Point.first(true).next(true);
        Assertions.assertThat(result).isEqualTo(new Point(true, false));
    }
}