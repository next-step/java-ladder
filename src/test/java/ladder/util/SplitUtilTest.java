package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @Test
    @DisplayName("구분자(,)를 기준으로 분리해서 배열로 반환한다.")
    void split() {
        assertThat(SplitUtil.split("paul, test")).isEqualTo(new String[]{"paul", "test"});
    }
}