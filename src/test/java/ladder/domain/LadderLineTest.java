package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    void 사다리_라인_랜덤_생성() {
        LadderLine ladderLine = LadderLine.generate(5);
        assertThat(ladderLine.getLines().size()).isEqualTo(4);
    }
}