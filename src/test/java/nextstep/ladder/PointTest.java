package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void 앞죄표가_true일_경우() {

        Point result = Point.addPoint(3, Arrays.asList(new Point(true), new Point(false), new Point(true)));
        assertThat(result).isEqualTo(new Point(false));
    }
}
