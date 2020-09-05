package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LadderLineGenerator;
import nextstep.ladder.domain.line.LadderLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    private int countOfUser;
    private int height;

    @BeforeEach
    void setUp() {
        countOfUser = 4;
        height = 5;
    }

    @Test
    void createLadderLine() {
        LadderLine ladderLine = LadderLineGenerator.generateLadderLine(height, countOfUser, () -> false);
        assertThat(ladderLine.size()).isEqualTo(5);
    }

}
