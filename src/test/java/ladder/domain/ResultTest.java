package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("결과값이 null이나 Empty이면 예외를 던진다.")
    void create_NullOrEmpty_ThrowException() {
        Assertions.assertThatNullPointerException().isThrownBy(new Result(""));
        Assertions.assertThatNullPointerException().isThrownBy(new Result(null));
    }
}
