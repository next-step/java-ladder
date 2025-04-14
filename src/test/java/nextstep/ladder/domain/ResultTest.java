package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    void createTest() {
        Result result = new Result("3000");

        assertThat(result).isEqualTo(new Result("3000"));
    }

    @Test
    void getValueTest() {
        Result result = new Result("3000");

        assertThat(result.getValue()).isEqualTo("3000");
    }
}
