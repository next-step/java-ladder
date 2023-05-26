package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    void create_결과_사람수_다름() {
        Assertions.assertThatThrownBy(() -> Results.create(new String[]{"a", "b"}, 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("결과와 사람의 수는 똑같아야 합니다.");
    }
}
