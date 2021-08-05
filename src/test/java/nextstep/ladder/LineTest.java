package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("사다리 줄 생성")
    void makeLineTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Line line = new Line(4, () -> 3);
            assertThat(line).isEqualTo(new Line(4, () -> 3));
        }
    }

}
