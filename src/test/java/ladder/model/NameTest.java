package ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    public void 이름의_길이가_5글자를_초과하면_예외가_난다() {
        String over5 = "123456";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(over5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    public void 이름의_길이가_5글자_이하면_올바르게_생성된다(String name) {
        assertThatCode(() -> new Name(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void 이름이_없거나_null_이면_예외가_난다(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }
}