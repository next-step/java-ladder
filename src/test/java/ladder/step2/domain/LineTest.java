package ladder.step2.domain;

import ladder.step2.domain.dto.LineDTO;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private List<Boolean> partLines;
    
    @BeforeEach
    void setUp() {
        Line line = new Line(5, new RandomLineCreateStrategy());
        LineDTO lineDTO = line.getLineInformation();
        partLines = lineDTO.getPartLines();
    }
    
    @Test
    @DisplayName("가로라인이 겹치지 않는지 확인")
    void correct_create_part_line() {
        IntStream.range(0, partLines.size() - 1)
                .forEach(index -> assertThat(partLines.get(index) && partLines.get(index + 1)).isFalse());
    }

    @Test
    @DisplayName("가로라인의 끝 부분은 부분라인이 없는지 확인")
    void last_part_line() {
        assertThat(partLines.get(partLines.size() - 1)).isFalse();
    }
    
}