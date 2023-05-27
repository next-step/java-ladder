package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("사람의 수만큼 Horizontal Line을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    public void generateLineTest(int countOfPerson) {
        assertThat(new Line(countOfPerson).getPoints()).hasSize(countOfPerson - 1);
    }

    @DisplayName("연속적인 가로줄은 있을 수 없다.")
    @Test
    public void shouldNotGenerateHorizontal() {
        assertThatThrownBy(() -> new Line(5, count -> List.of(true, true, true, false)))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("사다리타기 - 움직이지 않음")
    @Test
    public void testLine_움직이지_않음() {
        Line line1 = new Line(4, count -> List.of(false, false, false));
        assertThat(line1.nextIndex(0)).isEqualTo(0);
        assertThat(line1.nextIndex(1)).isEqualTo(1);
        assertThat(line1.nextIndex(2)).isEqualTo(2);
        assertThat(line1.nextIndex(3)).isEqualTo(3);
    }

    @DisplayName("사다리타기 - 이동")
    @Test
    public void testLine_이동() {
        Line line1 = new Line(4, count -> List.of(true, false, true));
        assertThat(line1.nextIndex(0)).isEqualTo(1);
        assertThat(line1.nextIndex(1)).isEqualTo(0);
        assertThat(line1.nextIndex(2)).isEqualTo(3);
        assertThat(line1.nextIndex(3)).isEqualTo(2);
    }
}
