package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LineTest {
    @Test
    void 사다리_한줄_생성확인() {
        int countOfPerson = 5;
        LadderLine ladderLine = new LadderLine(countOfPerson);

        assertThat(ladderLine.draw()).hasSize(countOfPerson);

    }
}
