package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("라인의 선 유무배열로 Line 객체를 생성한다.")
    @Test
    void create() {
        assertThat(Line.from(true, false, true)).isEqualTo(Line.from(true, false, true));
    }

}
