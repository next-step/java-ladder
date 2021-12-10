package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    @DisplayName("사람 수를 입력하여, 사다리의 가로줄 하나를(height=1) 생성한다.")
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        assertThat(ladderLine.getPoints().size()).isEqualTo(sizeOfPerson);
    }

}