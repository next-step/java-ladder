package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3", "2,5"})
    @DisplayName("사다리 높이와 line 수 확인")
    void createLadder(int countOfPerson, int ladderHeight) {
        Ladder ladder = LadderFactory.createLadder(countOfPerson, ladderHeight);

        List<Line> lineList = ladder.getLines();
        int resultHeight = lineList.size();
        int lineCount = lineList.get(0).getPoints().size();

        assertAll(
                () -> assertThat(resultHeight).isEqualTo(ladderHeight),
                () -> assertThat(lineCount).isEqualTo(countOfPerson)
        );
    }
}
