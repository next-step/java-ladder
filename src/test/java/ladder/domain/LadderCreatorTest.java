package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreatorTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3", "2,5"})
    void createLadder(int countOfPerson, int ladderHeight) {
        LadderCreator ladderCreator = new LadderCreator(countOfPerson, ladderHeight);
        Ladder ladder = ladderCreator.createLadder();

        List<Line> lineList = ladder.getLineList();
        int resultHeight = lineList.size();
        int lineCount = lineList.get(0).getPoints().size();

        assertAll(
                () -> assertThat(resultHeight).isEqualTo(ladderHeight),
                () -> assertThat(lineCount).isEqualTo(countOfPerson)
        );
    }
}
