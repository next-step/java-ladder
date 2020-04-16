package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

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
}
