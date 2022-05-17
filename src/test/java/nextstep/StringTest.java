package nextstep;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    void testEmptyAndBlank(String aString) {
        assertThat(aString.isEmpty()).isTrue();
        assertThat(aString.isBlank()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    void testBlank(String aString) {
        assertThat(aString.isEmpty()).isFalse();
        assertThat(aString.isBlank()).isTrue();
    }
}
