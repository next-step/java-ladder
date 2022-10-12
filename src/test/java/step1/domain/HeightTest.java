package step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateHeight(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(height));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isEqualsHeight(int h) {
        then(new Height(h).isEqualsHeight(new Height(h))).isTrue();
        then(new Height(h).isEqualsHeight(h)).isTrue();
    }
}