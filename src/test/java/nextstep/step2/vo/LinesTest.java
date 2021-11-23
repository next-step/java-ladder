package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @DisplayName("Null or Empty input illegal exception")
    @Test
    void nullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.create(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.create(Collections.emptyList()));
    }

}
