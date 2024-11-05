package ladder.domain.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitUtilTest {
    @Test
    void split() {
        List<String> actual = SplitUtil.split("pobi, crong, honux ,jk");
        List<String> expected = List.of("pobi", "crong", "honux", "jk");

        assertThat(actual).isEqualTo(expected);
    }
}
