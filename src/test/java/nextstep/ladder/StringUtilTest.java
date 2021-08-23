package nextstep.ladder;

import nextstep.ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @Test
    @DisplayName("사람 이름 쉼표로 구분")
    void separatorTest() {
        String inputString = "pobi,honux,crong,jk";
        List<String> names = StringUtil.separator(inputString);
        assertThat(names).contains("pobi","honux","crong","jk");
    }

    @Test
    @DisplayName("결과값 쉼표로 구분")
    void resultSeparatorTest() {
        String inputResultString = "꽝,5000,꽝,3000";
        List<String> results = StringUtil.separator(inputResultString);
        assertThat(results).contains("꽝","5000","꽝","3000");
    }
}
