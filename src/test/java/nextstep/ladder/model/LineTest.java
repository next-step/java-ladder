package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private final int COUNT_OF_PERSON = 3;
    private final int LEFT_TRUE_RIGHT_FALSE = 1;
    private final int IS_LEFT = 0;

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(Arrays.asList(true, true, false, true));
    }

    @DisplayName("(사람 수 - 1) 만큼의 사다리 Line 생성")
    @Test
    void Line_만들기() {
        Line line = new Line(COUNT_OF_PERSON);
        assertThat(line.getPoints().size()).isEqualTo(COUNT_OF_PERSON - 1);
    }

    @DisplayName("List<Boolean> 으로 Line 생성")
    @Test
    void Line_만들기2() {
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @DisplayName("한 줄짜리 사다리 테스트")
    @Test
    void goDownTest() {
        assertThat(line.goDown(LEFT_TRUE_RIGHT_FALSE)).isEqualTo(IS_LEFT);
    }
}
