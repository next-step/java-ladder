package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"danden, asdfegee"})
    void testInvalidLengthName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }

    @ParameterizedTest
    @EmptySource
    void testEmptyName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserName(name));
    }



}
