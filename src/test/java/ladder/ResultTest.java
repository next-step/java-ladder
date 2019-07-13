package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {
    @Test
    void create() {
        Result result = Result.of("1000");
        assertThat(result.getResult()).isEqualTo("1000");
    }

    @Test
    void getResultPad() {
        Result result = Result.of("1000");
        assertThat(result.getResultPad().length()).isEqualTo(6);
        assertThat(result.getResultPad()).isEqualTo("1000  ");
    }
}