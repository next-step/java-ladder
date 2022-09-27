package ladder.step2.domain;

import ladder.step2.domain.dto.LineDTO;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    
    @Nested
    @DisplayName("올바른 가로라인 생성 확인")
    class CorrectCreatePartLine {
        @DisplayName("가로라인이 겹치지 않는지 확인")
        @RepeatedTest(value = 100, name = "{displayName}")
        void correct_create_part_line() {
            Line line = new Line(5, new RandomLineCreateStrategy());
            LineDTO lineDTO = line.getLineInformation();
            List<Boolean> partLines = lineDTO.getPartLines();
            IntStream.range(0, partLines.size() - 1)
                    .forEach(index -> assertThat(partLines.get(index) && partLines.get(index + 1)).isFalse());
        }
    }
}