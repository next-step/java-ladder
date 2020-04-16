package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderCreatorTest {
    @DisplayName("사다리의 높이만큼 라인을 생성한다.")
    @Test
    void createLadder() {
        int countOfPerson = 5;
        int height = 4;
        LadderLineCreator lineCreator = new LadderLineCreator();
        LadderCreator ladderCreator = new LadderCreator(lineCreator);
        List<LadderLine> ladderLines = ladderCreator.create(countOfPerson, height);
        assertThat(ladderLines).hasSize(height);
    }
}
