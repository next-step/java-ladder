package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("Lines에 Line을 새로 추가하고 반환한다")
    @Test
    public void addLine_success() throws Exception {
        //given
        Lines lines = new Lines();
        Line line = new Line(Arrays.asList(new Node(2, new Way(false, false))));

        //when
        lines = lines.addLine(line);

        //then
        assertThat(lines.size()).isEqualTo(1);
        assertThat(lines.getLine(0).getNode(0).getIndex()).isEqualTo(2);
    }
}
