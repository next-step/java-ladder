package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("참가자가 4명일 때 높이가 3인 사다리를 만들 수 있다.")
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
