package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {

    @Test
    public void Line_생성테스트() {
        //given
        List<Boolean> list = new ArrayList<>(Arrays.asList(true, false, true));

        // when
        Line line = new Line(new TestLineGenerator(), 3);

        //then
        assertThat(line).isEqualTo(list);
    }
}