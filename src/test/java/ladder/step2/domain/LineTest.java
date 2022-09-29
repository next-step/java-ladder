package ladder.step2.domain;

import ladder.step2.domain.dto.LineDTO;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private List<PartLine> partLines;
    private PartLine truePartLine;
    private PartLine falsePartLine;
    
    @BeforeEach
    void setUp() {
        Line line = new Line(5, new RandomLineCreateStrategy());
        LineDTO lineDTO = line.getLineInformation();
        partLines = lineDTO.getPartLines();
        falsePartLine = new PartLine(false);
        truePartLine = new PartLine(true);
    }
    
    @Nested
    @DisplayName("가로라인이 겹치지 않는지 확인")
    class NotOverlappingLines {
        @RepeatedTest(100)
        void not_overlapping_lines() {
            IntStream.range(0, partLines.size() - 1)
                    .forEach(index -> assertThat(partLines.get(index).equals(truePartLine) && partLines.get(index + 1).equals(truePartLine)).isFalse());
        }
    }
    
    @Nested
    @DisplayName("가로라인 중 첫 부분은 부분라인이 없는지 확인")
    class LastPartLine {
        @RepeatedTest(100)
        void last_part_line() {
            assertThat(partLines.get(0)).isEqualTo(falsePartLine);
        }
    }
    
}