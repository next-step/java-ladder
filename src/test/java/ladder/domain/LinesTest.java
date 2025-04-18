package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @Test
    @DisplayName("사다리 높이는 양수여야 한다.")
    void ladderHeightShouldBePositive() {
        assertThatThrownBy(() -> new Lines(0, 2, () -> true)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lines(2, 0, () -> true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 높이와 폭은 입력한대로 생성된다.")
    void getLines() {
        assertThat(new Lines(3, 5, () -> true).getLines())
                .hasSize(3)
                .allMatch(line -> line.hasSameWidth(5));
    }

    @Test
    @DisplayName("사다리타기 실행 결과를 반환한다.")
    void getResult() {
        Lines lines = new Lines(1, 2, () -> true);
        assertThat(lines.moveLinesFrom(0)).isEqualTo(1);
        assertThat(lines.moveLinesFrom(1)).isEqualTo(0);
        assertThat(lines.moveLinesFrom(2)).isEqualTo(2);
    }
}
