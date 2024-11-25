package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private static Lines lines;

    @BeforeAll
    static void setUpBeforeClass() {
        lines = new Lines(6, 5);
    }

    @Test
    @DisplayName("사다리 라인 사이즈 확인")
    void size() {
        assertThat(lines.getValues()).hasSize(6);
    }
}
