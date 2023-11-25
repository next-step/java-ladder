package ladder.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName("왼쪽에서 부터 크기만큼 특정 문자열을 채워 넣는다.")
    public void leftPad(){
        Assertions.assertThat(StringUtils.leftPad("abc", 5, " ")).isEqualTo("  abc");
        Assertions.assertThat(StringUtils.leftPad("---", 5, "-")).isEqualTo("-----");
    }
}
