package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @BeforeEach
    void beforeEech() {
        line = new Line(5, true);
    }

    @Test
    @DisplayName("자신 Dot이 True인 경우, index + 1")
    void getLineIndex_ofFirstDot() {
        int result = line.getLineIndex(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("앞쪽 & 자신 Dot이 모두 False인 경우, index")
    void getLineIndex_ofLastDot() {
        int result = line.getLineIndex(4);
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("앞쪽 Dot이 True인 경우, index-1")
    void getLineIndex_ofSecondDot() {
        int result = line.getLineIndex(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void createLine_dotSize() {
        assertThat(line.getDots()).hasSize(5);
    }

    @Test
    void createLine_firstValueOfLine() {
        assertThat(line.getDots().get(0)).isTrue();
    }

    @Test
    void createLine_lastValueOfLine() {
        assertThat(line.getDots().get(4)).isFalse();
    }

    @Test
    void createLine_middleValueOfLine() {
        assertThat(!line.getDots().get(3)).isEqualTo(line.getDots().get(2));
    }
}
