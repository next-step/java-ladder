package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    int lineQuantity = 5;
    int lineHeight = 3;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(lineQuantity, lineHeight);
    }

    @Test
    @DisplayName("주어진 lineQuantity 만큼 level 마다 세로와 가로 라인이 생긴다")
    void constructor() {
        VerticalLines verticalLines = ladder.verticalLinesByLevel(0);
        HorizontalLines horizontalLines = ladder.horizontalLinesByLevel(0);

        assertThat(verticalLines.size()).isEqualTo(lineQuantity);
        assertThat(horizontalLines.size()).isEqualTo(lineQuantity);
    }

    @Test
    @DisplayName("주어진 height 만큼 level 이 생긴다")
    void constructor2() {
        assertThat(ladder.height()).isEqualTo(lineHeight);
    }
}
