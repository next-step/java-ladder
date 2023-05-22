package ladder.domain.model.Param;

import ladder.exception.LadderHeightArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightParamTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2, -3})
    void 모델_객체로_변환테스트(int height) {
        assertThatThrownBy(() -> {
            new LadderHeightParam(height);
        }).isInstanceOf(LadderHeightArgumentException.class)
                .hasMessageContaining("비어 있거나 잘못된 값을 입력하였습니다.");
    }
}
