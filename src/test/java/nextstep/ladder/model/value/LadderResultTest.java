package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {

    @Test
    @DisplayName("사다리 결과를 가지는 객체 생성 검증")
    void createTest() {
        LadderResult result = new LadderResult("꽝");

        assertThat(result).isEqualTo(new LadderResult("꽝"));
    }

    @Test
    @DisplayName("사다리 당첨 결과 길이가 5자리 넘었을 때 예외 검증")
    void sizeExceptionTest() {
        assertThatThrownBy(() ->
                new LadderResult("강남역 출구 앞 아파트")).isInstanceOf(IllegalArgumentException.class);
    }
}
