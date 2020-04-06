package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 높이만큼 라인을 생성한다.")
    @Test
    void createLadder() {
        int CountOfPerson = 5;
        int height = 4;
        Ladder ladder = new Ladder();

        List<Line> lines = ladder.createLadder(CountOfPerson, height);

        assertThat(lines).hasSize(height);
    }
}
