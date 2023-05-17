package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerticalLineTest {
    @Test
    void 인덱스를_지정하여_VerticalLine을_만들_수_있다() {
        assertThat(new VerticalLine(3).getIndex()).isEqualTo(3);
    }
}
