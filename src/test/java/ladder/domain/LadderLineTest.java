package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderLineTest {

    @DisplayName("사다리 왼쪽 이동")
    @Test
    void moveLadderLeft() {
        // given
        LadderLine ladderLine = new LadderLine(List.of(false, true, false));
        int startPosition = 2;

        // when
        int movedPosition = ladderLine.move(startPosition);
        int expected = startPosition - 1;

        // then
        Assertions.assertThat(movedPosition).isEqualTo(expected);
    }

    @DisplayName("사다리 오른쪽 이동")
    @Test
    void moveLadderRight() {
        // given
        LadderLine ladderLine = new LadderLine(List.of(false, true, false));
        int startPosition = 1;

        // when
        int movedPosition = ladderLine.move(startPosition);
        int expected = startPosition + 1;

        // then
        Assertions.assertThat(movedPosition).isEqualTo(expected);
    }
}
