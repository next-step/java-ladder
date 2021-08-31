package nextstep.ladder2;

import nextstep.ladder2.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderLineTest {

    @Test
    @DisplayName("사다리 라인 생성 테스트")
    void createLadderLineTest() {
        int personCount = 3;
        LadderLine ladderLine = new LadderLine(personCount);
        assertThat(ladderLine.getPointSize()).isEqualTo(personCount);
    }

    @Test
    @DisplayName("사다리 move")
    void moveTest() {
        int personCount = 3;
        int startIndex = 0;
        LadderLine ladderLine = new LadderLine(personCount);
        int movedIndex = ladderLine.move(startIndex);
        assertThat( movedIndex == 0 || movedIndex == 1).isTrue();
    }
}
