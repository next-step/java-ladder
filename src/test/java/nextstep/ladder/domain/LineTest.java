package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("하나의 사다리 라인 테스트")
public class LineTest {

    @DisplayName("사다리들을 가지고 있는 하나의 라인 객체를 생성한다.")
    @Test
    void line() {
        Assertions.assertThat(new Line(4,2)).isInstanceOf(Line.class);
    }
}
