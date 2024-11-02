package nextstep.ladder.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringUtilsTest {

    @Test
    void 쉼표로_구분하여_리스트반환() {
        String input = "pobi,honux,crong,jk";
        List<String> splited = StringUtils.splitByComma(input);
        Assertions.assertThat(splited).containsExactly("pobi", "honux", "crong", "jk");
    }
}
