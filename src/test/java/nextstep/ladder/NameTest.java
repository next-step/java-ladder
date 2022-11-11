package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void empty(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    void long_length() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("abcdef"));
    }
}
