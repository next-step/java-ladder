package ladder.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringFormatterTest {

    @Test
    @DisplayName("오른쪽에서 부터 크기만큼 특정 문자열을 채워 넣는다.")
    public void rightPad(){
        Assertions.assertThat(StringFormatter.rightPad("abc", 5, " ")).isEqualTo("abc  ");
        Assertions.assertThat(StringFormatter.rightPad("---", 5, "-")).isEqualTo("-----");
    }
}
