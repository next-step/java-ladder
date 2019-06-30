package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {
    int lineLength = 5;
    VerticalLine verticalLine;

    @BeforeEach
    void setUp() {
        verticalLine = new VerticalLine(lineLength, false);
    }

    @Test
    @DisplayName("주어진 길이로 VerticalLine 인스턴스 생성")
    void constructor() {
        assertThat(verticalLine.getLength()).isEqualTo(lineLength);
    }

    @Test
    @DisplayName("hasHorizontalLine 에 의해서 hasHorizontalLine 값이 다르다")
    void hasHorizontalLine() {
        VerticalLine hasHorizontal = new VerticalLine(lineLength, true);

        assertThat(verticalLine.hasHorizontalLine()).isFalse();
        assertThat(hasHorizontal.hasHorizontalLine()).isTrue();

    }
}
