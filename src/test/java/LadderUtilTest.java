import ladder.IllegalSplitCommaException;
import ladder.LadderUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"a,b,c,d:4", "a,b,c:3", "a,b:2"}, delimiter = ':')
    void splitStringByComma(String input, String expected) {
        List<String> result = LadderUtil.splitStringByComma(input);

        assertThat(result).hasSize(Integer.parseInt(expected));
    }


    @ParameterizedTest
    @ValueSource(strings = {"abcd", "a b c"})
    void illegalSplitCommaExceptionTest(String input) {
        assertThatExceptionOfType(IllegalSplitCommaException.class).isThrownBy(() -> {
            LadderUtil.splitStringByComma(input);
        });
    }
}
