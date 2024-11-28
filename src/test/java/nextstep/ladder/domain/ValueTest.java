package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.dto.Value;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "tessss"})
    public void 잘못된_이름_작성시_예외가_발생한다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Value(name));
    }
}
