package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @DisplayName("value 의 크기가 1 보다 작을 경우 illegal exception")
    @Test
    void lessThanOneTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Height.create(0));
    }

    @DisplayName("Null or Empty String input illegal exception")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Height.createWithString(input));
    }
}
