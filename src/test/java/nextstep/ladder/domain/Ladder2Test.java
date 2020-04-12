package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ladder2Test {
    @DisplayName("사다리의 높이만큼 라인을 생성한다.")
    @Test
    void createLadder() {
        int countOfPerson = 5;
        int height = 4;
        Ladder2 ladder = new Ladder2(countOfPerson, height);
        List<LadderLine> ladderLines = ladder.getLadder();
        assertThat(ladderLines).hasSize(height);
    }
}
