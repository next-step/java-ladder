package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인 생성후 가로줄 겹치느지 여부 테스트")
    void create() {
        int countOfPerson = 5;
        Line line = new Line(5);

        assertThat(line.pointListSize()).isEqualTo(countOfPerson);
        assertThat(isOverlapping(line)).isFalse();
    }

    private boolean isOverlapping(Line line) {
        for (int i = 1; i < line.pointListSize(); i++) {
            boolean previousPointIsFilled = line.isFilledAt(i - 1);
            if (previousPointIsFilled && line.isFilledAt(i)) {
                return true;
            }
        }
        return false;
    }
}
