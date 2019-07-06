package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리는 높이와 참가자들의 수로 생성된다.")
    void new_WithHeightAndNumberOfParticipants_Created() {
        final int height = 5;
        final int numberOfParticipants = 7;
        final Ladder ladder = new Ladder(height, numberOfParticipants);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }
}
