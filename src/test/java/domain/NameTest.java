package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobiab", "nimoha", "ccxsqe"})
    void create_exception(String overRangeName) {
        assertThatThrownBy(() -> Name.from(overRangeName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobia", "nimoh", "ccxsq"})
    void create_success(String overRangeName) {
        assertThatNoException().isThrownBy(() -> Name.from(overRangeName));
    }
}
