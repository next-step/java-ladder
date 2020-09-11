package cc.oakk.ladder.model.result;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void constructor_ShouldThrow(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Result(name));
    }
}
