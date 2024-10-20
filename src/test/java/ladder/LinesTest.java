package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("사다리 라인을 2개 만들 수 있다.")
    @Test
    void createTwoLines() {
        Line line1 = new Line(List.of(true));
        Line line2 = new Line(List.of(true));

        Lines lines = new Lines(List.of(line1, line2));

        assertThat(lines).isEqualTo(new Lines(List.of(line1, line2)));
    }

    @DisplayName("4명에 대해 높이가 3인 사다리를 만들 수 있다.")
    @Test
    void create() {
        Lines lines = new Lines(4, 3, () -> true);

        assertThat(lines).isEqualTo(new Lines(
                List.of(
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true))
                ))
        );
    }
}
