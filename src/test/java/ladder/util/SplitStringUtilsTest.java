package ladder.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SplitStringUtilsTest {
    @Test
    void split_문자열_콤마_구분() {
        assertThat(SplitStringUtils.split("wu2ee,pobi, honux,   kbs", ",")).isEqualTo(List.of("wu2ee", "pobi", "honux", "kbs"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void split_입력문자열_비어있는_경우(String elem) {
        assertThatThrownBy(() -> SplitStringUtils.split(elem, ",")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void split_구분자가_비어있는_경우(String delimiter) {
        assertThatThrownBy(() -> SplitStringUtils.split("wu2ee,pobi,honux,kbs", delimiter)).isInstanceOf(IllegalArgumentException.class);
    }
}
