package nextstep.ladder.domain.lines;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.strategy.line.LineCreationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLinesFactoryTest {

    @Test
    @DisplayName("이전 라인과 포인트들이 겹치지 않게 동일한 길이로 구성된 랜덤 사다리를 생성한다.")
    void create_random_lines() {
        // given
        int height = 4;
        int participantCount = 3;
        List<List<Boolean>> given = List.of(
                List.of(true, false, false, true),
                List.of(false, true, false, false),
                List.of(true, false, false, true)
        );

        // when
        RandomLinesFactory randomLinesFactory = new RandomLinesFactory(new TestLineCreationStrategy(given));
        Lines result = randomLinesFactory.createLines(height, participantCount);

        // then
        assertThat(result).isEqualTo(createExpectedLines());
    }

    private class TestLineCreationStrategy implements LineCreationStrategy {
        private final List<List<Boolean>> lines;
        private int index = 0;

        TestLineCreationStrategy(List<List<Boolean>> lines) {
            this.lines = lines;
        }

        @Override
        public Line createNextLine(Line beforeLine, int height) {
            List<Boolean> pointStatus = lines.get(index);
            index++;
            return Line.createLineWithPointStatus(pointStatus);
        }
    }

    private Lines createExpectedLines() {
        return new Lines(
                List.of(
                        Line.createLineWithPointStatus(List.of(true, false, false, true)),
                        Line.createLineWithPointStatus(List.of(false, true, false, false)),
                        Line.createLineWithPointStatus(List.of(true, false, false, true))
                )
        );
    }
}
