package nextstep.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @Test
    void 문자열을_구분자를_기준으로_분해한다() {
        // given
        String text = "a" + StringParser.DELIMINATOR + "b" + StringParser.DELIMINATOR + "c";

        // when
        List<String> result = StringParser.split(text);

        // then
        assertThat(result).containsExactly("a", "b", "c");
    }
}
