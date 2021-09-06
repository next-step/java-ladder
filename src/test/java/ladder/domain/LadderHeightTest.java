package ladder.domain;

import ladder.exception.LadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderHeightTest {

    @ParameterizedTest
    @DisplayName("사다리의 길이가 0 이하일 경우 LadderHeightException")
    @ValueSource(ints = {-1, 0})
    void heightException(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(LadderHeightException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 길이 생성")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void create(int height) {
        LadderHeight ladderHeight = new LadderHeight(height);
        int expected = ladderHeight.toInt();
        assertThat(height).isEqualTo(expected);
    }
}