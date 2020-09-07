package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.BDDAssertions.then;

class LineTest {

    @Test
    @DisplayName("인원이 1인 경우 페달 여부 검증")
    void getPedalsStatus() {
        then(Line.of(1).getPedalsStatus()).isEqualTo(Collections.singletonList(Boolean.FALSE));
    }
}
