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
    void getList() {
        assertThat(new Lines(3, 5, () -> true).getList())
                .hasSize(3)
                .allMatch(line -> line.size() == 5);
    }
}