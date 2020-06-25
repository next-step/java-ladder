package nextstep.step2;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    @DisplayName("List<Line> 생성 확인")
    @Test
    void getLines() {
        Lines lines = Lines.of(10);
        List<Line> newLines = lines.createLines(10);
        assertThat(newLines.size()).isEqualTo(9);
    }
}
