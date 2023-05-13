package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("가로 라인 생성 테스트")
    void drawLineTest() {
        Line line = Line.draw(5, new DrawStrategy() {
            @Override
            public boolean drawFirstPosition() {
                return false;
            }

            @Override
            public boolean drawNextPosition(Step previousStep) {
                return false;
            }
        });

        assertThat(line.numberOfSteps())
                .isEqualTo(5);
    }

}
