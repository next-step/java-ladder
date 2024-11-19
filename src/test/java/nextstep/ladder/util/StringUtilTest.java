package nextstep.ladder.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    void 문자를_분리하고_리스트를_반환한다() {
        assertThat(StringUtil.convert("명란젓,스파게티", ",")).containsExactlyInAnyOrderElementsOf(List.of("명란젓", "스파게티"));
    }
}
