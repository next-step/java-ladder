package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("사다리 높이 체크")
    void createLadder(int ladderHeight) {
        int countOfPerson = 3;
        Ladder ladder = new Ladder(countOfPerson, ladderHeight);

        LineList lineList = ladder.createLadder();

        int ladderHeightResult = lineList.getLineList().size();
        assertThat(ladderHeightResult).isEqualTo(ladderHeight);
    }
}
