package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("사다리 전체 출력 확인")
    void check() {
        Lines lines = new Lines(6, 3);
        System.out.println(lines.toString("\n", "|", "-----", "     "));
    }

    @Test
    @DisplayName("사다리 라인 사이즈 확인")
    void size() {
        Lines lines = new Lines(6, 3);
        assertThat(lines.getValue()).hasSize(6);
    }
}
