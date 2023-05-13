package nextstep.ladder.domain;

import nextstep.ladder.domain.util.DrawStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("가로 라인 결과 인덱스 변환 테스트")
    void firstStepToPositionTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.lastStep();

        Line line = new Line(List.of(step1, step2));
        List<Position> positions = line.stepsToPositions();

        assertThat(positions.get(0))
                .usingRecursiveComparison()
                .isEqualTo(new Position(0, step1));

        assertThat(positions.get(1))
                .usingRecursiveComparison()
                .isEqualTo(new Position(1, step2));
    }
}
