package nextstep.ladder.doman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -5})
    void 사다리_높이가_1보다_낮은_경우(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void 사다리_높이_생성(int height) {
        assertThat(new LadderHeight(height)).isEqualTo(new LadderHeight(height));
    }
}
