package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Line.createOneLine;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line은 사람수 - 1 에 해당하는 연결 여부 정보를 저장")
    void check_line_size() {
        int numberOfName = 3;
        Line line = createOneLine(numberOfName);
        assertThat(line.getPoints().size()).isEqualTo(numberOfName - 1);
    }

    @Test
    @DisplayName("Line은 TRUE를 연속으로 가질 수 없다.")
    void check_ladder_height() {
        List<Boolean> connectedLine = List.of(Boolean.TRUE, Boolean.TRUE);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Line(connectedLine);
        });
    }
}
