package step2;

import org.junit.jupiter.api.Test;
import step2.model.Line;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 라인_생성() {
        //given
        Line expect = new Line(Arrays.asList(true, false, true));

        //when
        Line actual = new Line(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
