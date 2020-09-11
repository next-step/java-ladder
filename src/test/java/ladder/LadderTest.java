package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private int userCount = 2;
    private Height height;

    @BeforeEach
    public void setup() {
        height = new Height(1);
    }

    @Test
    @DisplayName("사다리가 생성되는지")
    public void isLadderGenerated() {
        Ladder ladder = new Ladder(userCount, height);

        assertThat(ladder.getLadder().size()).isEqualTo(1);
    }
}
