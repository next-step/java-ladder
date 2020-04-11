import ladder.LadderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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


    @Test
    void illegalSplitCommaExceptionTest(String input, String expected) {
        assertThatExceptionOfType(IllegalSplitCommaException.class).isThrownBy(() -> {
            LadderUtil.splitStringByComma(input);
        });
    }
}
