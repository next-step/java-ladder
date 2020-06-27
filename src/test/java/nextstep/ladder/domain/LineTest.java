package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    public void Line() {
        //given
        int length = 5;

        //when
        Line line = new Line(length, () -> true);

        //then
        System.out.println(line);
        assertThat(line.getLadderLength()).isEqualTo(length);
        assertThat(line.getLine()).isEqualTo(Arrays.asList(true, false, true, false, true));
    }
}