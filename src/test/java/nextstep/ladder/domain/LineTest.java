package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("하나의 사다리 라인 테스트")
public class LineTest {

    private String[] participants = {"pobi","honux","crong","jk"};

    @DisplayName("사다리들을 가지고 있는 하나의 라인 객체를 생성한다.")
    @Test
    void line() {
        Assertions.assertThat(new Line(participants)).isInstanceOf(Line.class);
    }
}
