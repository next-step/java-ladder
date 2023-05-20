package nextstep.ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void 사다리_높이_객체_생성_테스트(int height) throws Exception {
        assertThat(new LadderHeight(height)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-120, 0, -12})
    public void 사다리_높이_객체_예외_테스트(int height) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(height));
    }
}
