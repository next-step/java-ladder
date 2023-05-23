package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 8, 23, 100})
    public void LadderHeight_객체_생성_테스트(int height) throws Exception {
        LadderHeight ladderHeight = new LadderHeight(height);
        assertThat(ladderHeight.getHeight()).isEqualTo(height);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -22, -34})
    public void LadderHeight_생성자_예외_테스트(int height) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(height));
    }

}
