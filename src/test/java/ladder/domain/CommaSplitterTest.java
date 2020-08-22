package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommaSplitterTest {

    @Test
    @DisplayName("null or empty 문자열")
    void testSplitBlank() {
        assertThatThrownBy(() -> CommaSplitter.split("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CommaSplitter.split(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CommaSplitter.split(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 실행")
    void testSplit() {
        final String str = "a,b,c";
        assertThat(CommaSplitter.split(str)).containsExactly("a", "b", "c");
    }
}
