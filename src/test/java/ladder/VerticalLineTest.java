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
        verticalLine = new VerticalLine(lineLength);
    }

    @Test
    @DisplayName("주어진 길이로 VerticalLine 인스턴스 생성")
    void constructor() {
        assertThat(verticalLine.getLength()).isEqualTo(lineLength);
    }

    @Test
    @DisplayName("최초 생성된 VerticalLine 은 HorizontalLine 이 없다")
    void hasDefaultHorizontalLine() {
        assertThat(verticalLine.hasHorizontalLine()).isFalse();
    }
}
