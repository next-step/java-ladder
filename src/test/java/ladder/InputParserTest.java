package ladder;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    @DisplayName("일반적인 인풋")
    void testSample() {
        List<String> expected = Arrays.asList("pobi", "honux", "crong", "jk");
        assertThat(InputParser.parseRawInput("pobi,honux,crong,jk"))
                .isEqualTo(expected);
    }
}
