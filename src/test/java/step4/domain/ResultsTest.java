package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @Test
    void 실행결과_5글자넘으면_에러_반환() {
        assertThatThrownBy(() -> new Results(List.of("꽝꽝꽝꽝꽝꽝꽝"), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행결과_빈값이면_에러_반환() {
        assertThatThrownBy(() -> new Results(Collections.emptyList(), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인원수만큼_입력되지않으면_에러_반환() {
        assertThatThrownBy(() -> new Results(List.of("꽝", "당첨", "꽝"), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
