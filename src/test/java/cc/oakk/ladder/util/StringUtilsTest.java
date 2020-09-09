package cc.oakk.ladder.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void isEmpty_ReturnTrue(String target) {
        assertThat(StringUtils.isEmpty(target)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Not", "Empty", " Also", "  NotEmpty  " })
    public void isEmpty_ReturnFalse(String target) {
        assertThat(StringUtils.isEmpty(target)).isFalse();
    }
}
