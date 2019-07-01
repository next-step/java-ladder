package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {
    int height = 5;
    VerticalLine verticalLine;

    @BeforeEach
    void setUp() {
        verticalLine = new VerticalLine(height, false);
    }

    @Test
    @DisplayName("주어진 길이로 VerticalLine 인스턴스 생성")
    void constructor() {
        assertThat(verticalLine.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("생성자에 따라서 hasLeftHorizontalLine 값이 다르다")
    void hasHorizontalLine() {
        VerticalLine hasHorizontal = new VerticalLine(height, true);

        assertThat(verticalLine.hasLeftHorizontalLine()).isFalse();
        assertThat(hasHorizontal.hasLeftHorizontalLine()).isTrue();

    }
}
