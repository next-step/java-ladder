package ladder.gilbert.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void formatted() {
        assertThat(new Result(new Person("a"), new Goal("goal")).formatted()).isEqualTo("a : goal");
    }
}
