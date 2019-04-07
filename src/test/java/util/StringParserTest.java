package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    public void 전달받은_문자열을_구분자로_나눈다() {
        assertThat(StringParser.split("a,b,c,d,e")).hasSize(5);
    }

    @Test
    public void 공백을_제거하고_나눈다() {
        assertThat(StringParser.split("a, b   ,c   ")).hasSize(3);
    }
}
