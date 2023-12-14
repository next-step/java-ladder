package nextstep.ladder;

import nextstep.ladder.domain.Results;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ResultsTest {

    @Test
    void 결과_사이즈_보다_큰_인덱스_값으로_결과를_꺼낼_수_없다() {
        Results results = new Results(List.of("1000", "꽝"));
        Throwable throwable = catchThrowable(() -> results.getResultByPosition(3));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과 개수보다 포지션 값이 큽니다.");
    }
}
