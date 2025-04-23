package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PrizeTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void 상품_이름은_빈값일경우_에러(String name) {
        assertThatThrownBy(() -> new Prize(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
