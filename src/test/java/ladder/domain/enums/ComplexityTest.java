package ladder.domain.enums;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexityTest {

    @Test
    public void 난이도_상() {
        assertThat(Complexity.of("상")).isEqualTo(Complexity.HARD);
    }

    @Test
    public void 난이도_중() {
        assertThat(Complexity.of("중")).isEqualTo(Complexity.NORMAL);
    }

    @Test
    public void 난이도_하() {
        assertThat(Complexity.of("하")).isEqualTo(Complexity.EASY);
    }
}
