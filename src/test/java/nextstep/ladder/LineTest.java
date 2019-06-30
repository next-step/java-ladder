package nextstep.ladder;

import nextstep.ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private final int COUNT_OF_PERSON = 3;

    @DisplayName("(사람 수 - 1) 만큼의 사다리 Line 생성")
    @Test
    void Line_만들기() {
        Line line = new Line(COUNT_OF_PERSON);
        assertThat(line.getPoints().size()).isEqualTo(COUNT_OF_PERSON - 1);
    }

    @DisplayName("List<Boolean> 으로 Line 생성")
    @Test
    void Line_만들기2() {
        Line line = new Line(Arrays.asList(true, false, true, true));
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}
