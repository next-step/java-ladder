package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

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

    @Test
    @DisplayName("사다리에서 얻은 Lines는 수정할 수 없다.")
    void getLines_Modify_ExceptionThrown() {
        final int height = 5;
        final int numberOfParticipants = 7;
        final Ladder ladder = new Ladder(height, numberOfParticipants);
        final List<Line> lines = ladder.getLines();
        assertThatThrownBy(() -> lines.add(Line.generateRandom(numberOfParticipants)))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }
}
