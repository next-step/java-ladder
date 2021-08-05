package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("사다리 줄 생성")
    void makeLineTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = new Lines(4, () -> true);
            assertThat(lines).isEqualTo(new Lines(4, () -> true));
        }
    }

    @Test
    @DisplayName("사다리 줄 생성")
    void makeLineFalseTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = new Lines(3, () -> false);
            assertThat(lines).isEqualTo(new Lines(3, () -> false));
        }
    }

}
