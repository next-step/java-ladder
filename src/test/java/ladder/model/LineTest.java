package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        int numberOfName = 100000;
        Line line = createOneLine(numberOfName);

        Boolean beforeState = line.getPoints().get(0);
        for (int i = 1; i < line.getPoints().size(); i++) {
            Boolean nowState = line.getPoints().get(i);
            if (beforeState && nowState) {
                throw new IllegalArgumentException("사다리 가로줄은 연속해서 그릴 수 없음");
            }
            beforeState = nowState;
        }

    }
}
