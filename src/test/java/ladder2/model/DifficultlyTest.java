package ladder2.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DifficultlyTest {
    public static final Difficultly DEFAULT_DIFFICULTLY = Difficultly.NORMAL;

    @Test
    public void 난이도_상() {
        assertThat(Difficultly.from("상")).isEqualTo(Difficultly.HARD);
    }

    @Test
    public void 난이도_중() {
        assertThat(Difficultly.from("중")).isEqualTo(Difficultly.NORMAL);
    }

    @Test
    public void 난이도_하() {
        assertThat(Difficultly.from("하")).isEqualTo(Difficultly.EASY);
    }

    @Test
    public void 반환_타입() {
        assertThat(DEFAULT_DIFFICULTLY.generateValue()).isInstanceOf(Boolean.class);
    }
}