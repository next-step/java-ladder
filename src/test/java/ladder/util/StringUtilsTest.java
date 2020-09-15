package ladder.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void validEmpty() {
        Assertions.assertThat(StringUtils.validEmpty("1234"))
                .isEqualTo(false);
        Assertions.assertThat(StringUtils.validEmpty(""))
                .isEqualTo(true);
        Assertions.assertThat(StringUtils.validEmpty(null))
                .isEqualTo(true);
    }
}