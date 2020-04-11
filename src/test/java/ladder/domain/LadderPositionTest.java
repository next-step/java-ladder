package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderPositionTest {
    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 10, 100})
    void create(int input) {
        LadderPosition ladderPosition = LadderPosition.of(input);

        assertThat(ladderPosition.getPosition()).isEqualTo(input);
    }

    @DisplayName("LadderPosition 은 음수 일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void exceptByCreation(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderPosition.of(input);
        });
    }

    @DisplayName("LadderPosition 은 LadderLine 에 의존해 움직인다.")
    @Test
    void move() {
        LadderLine ladderLine = LadderLine.of(Arrays.asList(
                LadderLink.DIS_CONNECT,
                LadderLink.CONNECT,
                LadderLink.DIS_CONNECT));
        LadderPosition ladderPosition = LadderPosition.of(0);
        LadderPosition ladderPosition2 = LadderPosition.of(1);

        assertThat(ladderPosition.move(ladderLine)).isEqualTo(LadderPosition.of(1));
        assertThat(ladderPosition2.move(ladderLine)).isEqualTo(LadderPosition.of(0));
    }
}
