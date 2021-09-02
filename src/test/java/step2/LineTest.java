package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 사다리_라인_생성() {
        //given
        Line expect = new Line(Arrays.asList(true, false, true, false));

        //when
        Line actual = new Line(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
