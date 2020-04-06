package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 높이만큼 라인을 생성한다.")
    @Test
    void createLadder() {
        int countOfPerson = 5;
        int height = 4;
        Ladder ladder = new Ladder();

        List<Line> lines = ladder.createLadder(countOfPerson, height);

        assertThat(lines).hasSize(height);
    }
}
