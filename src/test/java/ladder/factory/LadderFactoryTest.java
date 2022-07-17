package ladder.factory;

import ladder.domain.first.HorizontalLines;
import ladder.domain.first.Ladder;
import ladder.domain.SequentialConnectionStrategy;
import ladder.engine.LineCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {
    @DisplayName("정상적으로 Ladder 가 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = "4:3", delimiter = ':')
    void create(int heightOfLadder, int countOfLines) {
        List<LineCreator> lineCreators = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            lineCreators.add(new HorizontalLines(countOfLines - 1));
        }
        Ladder ladder = new Ladder(lineCreators, new SequentialConnectionStrategy());
        List<HorizontalLines> verticalLines = ladder.getLines();
        assertThat(verticalLines).hasSize(heightOfLadder);
    }
}