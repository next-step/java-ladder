package nextstep.ladder;

import nextstep.ladder.domain.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ResultTest {

    @Test
    void 결과는_빈값이면_안되며_최대_5자리이다() {
        Throwable throwable = catchThrowable(() -> new Result("123456"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 빈값이면 안되며, 최대 5자리입니다.");
    }
}
