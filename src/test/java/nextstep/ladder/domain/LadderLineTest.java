package nextstep.ladder.domain;

import nextstep.ladder.domain.ladderline.LadderGenerator;
import nextstep.ladder.domain.ladderline.LadderLine;
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
        LadderLine ladderLine = LadderGenerator.generateLadderLine(height, countOfUser, () -> false);
        assertThat(ladderLine.size()).isEqualTo(5);
    }

}
