package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringUtilTest {

    @Test
    @DisplayName("\",\" 기준으로 분리한 문자열을 반환한다.")
    public void splitWithComma() throws Exception {
        List<String> names = StringUtil.splitWithComma("pobi, dobi");
        assertThat(names).containsExactly("pobi", "dobi");
    }

    @Test
    @DisplayName("구분자가 존재하지 않을 경우 예외가 발생한다.")
    public void checkDelimiter() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtil.splitWithComma("no comma"));
    }
}
