package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("사다리 이동 불가능")
    @ValueSource(ints = {-1, 4})
    @ParameterizedTest
    void moveLadderImpossible(int position) {
        Assertions.assertThatThrownBy(() -> {
            // given
            LadderLine ladderLine = new LadderLine(List.of(false, true, false));

            // when
            ladderLine.move(position);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LadderLine 생성 시 true가 연속된 리스트가 입력되면 안됨")
    @Test
    void generateLadderLine() {
        Assertions.assertThatThrownBy(() -> new LadderLine(List.of(true, true, true)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid points");

    }
}
