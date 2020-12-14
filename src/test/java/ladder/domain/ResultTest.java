package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("동일성 테스트")
    void testEquality() {
        Result arg1 = new Result(new User("BSH"), new Reward("1등"));
        Result arg2 = new Result(new User("BSH"), new Reward("1등"));

        assertThat(arg1).isEqualTo(arg2);
    }
}
