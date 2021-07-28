package nextstep.ladder.domain.result;

import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("결과 그룹을 표현하는 클래스 테스트")
class ResultsTest {

    @DisplayName("결과 그룹은 결과 리스트를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Results.init(Arrays.asList("꽝", "1000", "500"))).isInstanceOf(Results.class);
    }

    @DisplayName("결과 리스트가 null 일 경우 예외를 발생시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> Results.init(null)).isInstanceOf(NullArgumentException.class);
    }
}
