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
        int startIndex = 2;
        Position startPosition = new Position(startIndex);

        // when
        Position movedPosition = ladderLine.move(startPosition);
        Position expected = new Position(startIndex - 1);

        // then
        Assertions.assertThat(movedPosition).isEqualTo(expected);
    }

    @DisplayName("사다리 오른쪽 이동")
    @Test
    void moveLadderRight() {
        // given
        LadderLine ladderLine = new LadderLine(List.of(false, true, false));
        int startIndex = 1;
        Position startPosition = new Position(startIndex);

        // when
        Position movedPosition = ladderLine.move(startPosition);

        // then
        Assertions.assertThat(movedPosition).isEqualTo(new Position(startIndex + 1));
    }

    @DisplayName("사다리 이동 불가능")
    @ValueSource(ints = {-1, 4})
    @ParameterizedTest
    void moveLadderImpossible(int index) {
        Assertions.assertThatThrownBy(() -> {
            // given
            LadderLine ladderLine = new LadderLine(List.of(false, true, false));
            Position position = new Position(index);

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
