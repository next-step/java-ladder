package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 라인이_겹치는_경우_테스트() {
        boolean result = Line.isEqual(true, true);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 라인이_안겹치는_경우_테스트() {
        boolean result = Line.isEqual(false, true);
        assertThat(result).isEqualTo(false);
    }
}