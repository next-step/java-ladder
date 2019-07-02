package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {
    VerticalLine verticalLine;

    @BeforeEach
    void setUp() {
        verticalLine = new VerticalLine(false);
    }

    @Test
    @DisplayName("생성자에 따라서 hasLeftHorizontalLine 값이 다르다")
    void hasHorizontalLine() {
        VerticalLine hasHorizontal = new VerticalLine(true);

        assertThat(verticalLine.hasLeftHorizontalLine()).isFalse();
        assertThat(hasHorizontal.hasLeftHorizontalLine()).isTrue();

    }
}
