package ladder.domain;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EdgeLineTest {
    @DisplayName("라인의 길이는 사람 수 * 2 - 1 이고, 시작과 끝에 수직선이 있어야 하고, 수직선의 총 갯수는 사람 수와 같다.")
    @Test
    void points() {
        int countOfPerson = 3;
        assertThat(new EdgeLine(countOfPerson).getPoints())
                .hasSize(countOfPerson * 2 - 1)
                .startsWith(VERTICAL_LINE)
                .endsWith(VERTICAL_LINE)
                .areExactly(countOfPerson, new Condition<Point>() {
                    @Override
                    public boolean matches(Point point) {
                        return point == VERTICAL_LINE;
                    }
                });
    }

    @DisplayName("이전 포인트와 상관없이 수평선 / 공백이 온다.")
    @Test
    void choiceBeforeLast() {
        Line edgeLine = new EdgeLine(3); 
        for (Point point : values()) {
            assertThat(edgeLine.choiceBeforeLast(point)).isIn(HORIZON, BLANK);
        }
    }
}
