package ladder.step2.domain.strategy;

import ladder.step2.domain.PartLine;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomLineCreateStrategyTest {
    private List<PartLine> partLines;
    
    @BeforeEach
    void setUp() {
        RandomLineCreateStrategy randomLineCreateStrategy = new RandomLineCreateStrategy();
        partLines = randomLineCreateStrategy.addPartLine(5);
    }
    
    @Nested
    @DisplayName("가로라인이 겹치지 않는지 확인")
    class NotOverlappingLines {
        @RepeatedTest(100)
        void not_overlapping_lines() {
            IntStream.range(0, partLines.size() - 1)
                    .forEach(index -> assertThat(partLines.get(index).equals(new PartLine(true)) && partLines.get(index + 1).equals(new PartLine(true))).isFalse());
        }
    }
    
    @Nested
    @DisplayName("가로라인 중 첫 부분은 부분라인이 없는지 확인")
    class LastPartLine {
        @RepeatedTest(100)
        void last_part_line() {
            assertThat(partLines.get(0)).isEqualTo(new PartLine(false));
        }
    }
}