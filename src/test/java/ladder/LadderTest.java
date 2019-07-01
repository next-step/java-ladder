package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("주어진 수직 라인 갯수로 사다리가 생성된다.")
    void constructor() {
        int lineQuantity = 5;
        int lineHeight = 3;
        Ladder ladder = new Ladder(lineQuantity, lineHeight);
        HorizontalLines horizontalLines = ladder.horizontalLinesByLevel(0);

        assertThat(horizontalLines.size()).isEqualTo(lineQuantity);
    }
}
