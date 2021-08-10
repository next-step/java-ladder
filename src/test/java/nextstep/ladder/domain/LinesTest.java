package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @Test
    @DisplayName("사다리 줄 생성 true")
    void makeLineTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(4, () -> true);
            assertThat(lines).isEqualTo(Lines.of(4, () -> true));
        }
    }

    @Test
    @DisplayName("사다리 줄 생성 false")
    void makeLineFalseTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(3, () -> false);
            assertThat(lines).isEqualTo(Lines.of(3, () -> false));
        }
    }

}
