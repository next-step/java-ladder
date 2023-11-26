package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인 일급 컬렉션 테스트")
public class LinesTest {

    @DisplayName("라인 객체를 추가한다.")
    @Test
    void addLine() {
        Lines lines = new Lines();
        lines.addLine(new Line(1,1));
    }
}
