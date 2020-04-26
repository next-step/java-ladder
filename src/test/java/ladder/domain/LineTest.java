package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LineTest {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int CENTER = 0;

    @DisplayName("가로줄이 존재하는지 테스트")
    @Test
    void testLineEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(0));
    }

    @DisplayName("생성된 가로줄값 테스트")
    @Test
    void testWidthTrueFalse() {
        List<Boolean> expected = Arrays.asList(false, true);

        Line line = new Line(expected.size(), new WidthGenerator(expected));
        List<Boolean> actual = line.getWidthLines();

        assertThat(actual.get(1)).isTrue();
    }

    @Test
    void testMoveLine() {
        List<Boolean> expected = Arrays.asList(true, true, false, true);
        int myPosition = 1;
        Line line = new Line(expected.size(), new WidthGenerator(expected));
        assertThat(line.move(myPosition)).isEqualTo(LEFT);
    }

}
