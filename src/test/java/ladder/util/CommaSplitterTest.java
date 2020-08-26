package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommaSplitterTest {

    @Test
    @DisplayName("null or empty split 시 예외")
    void testSplitBlankString() {
        assertThatThrownBy(() -> CommaSplitter.split("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CommaSplitter.split(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CommaSplitter.split(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 실행")
    void testSplitString() {
        String[] array = {"a","b","c"};
        assertThat(CommaSplitter.split(String.join(",", array))).containsExactly(array);
    }
}
