package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {
    @Test
    @DisplayName("주어진 길이로 VerticalLine 인스턴스 생성")
    void constructor() {
        int lineLength = 5;
        VerticalLine verticalLine = new VerticalLine(lineLength);
        assertThat(verticalLine.getLength()).isEqualTo(lineLength);
    }
}
