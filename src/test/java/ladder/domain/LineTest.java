package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test(expected = IllegalArgumentException.class)
    public void 가로라인_겹칠때_검증() {
        Line.of(Arrays.asList(Point.of(true), Point.of(true), Point.of(false), Point.of(true)));

    }

    @Test
    public void 가로라인_겹치지않을때_검증() {
        Line.of(Arrays.asList(Point.of(true), Point.of(false), Point.of(false), Point.of(true)));
    }


    @Test
    public void 랜덤포인트생성_검증() {
        Line.of(20);
    }
}
