package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LadderResultTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void 사다리_결과는_존재해야_한다(String value) throws Exception {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(value));
    }
}