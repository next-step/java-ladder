package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LadderLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    private LadderLine ladderLine;
    private int countOfUser;

    @BeforeEach
    void setUp() {
        countOfUser = 4;
    }

    @Test
    @DisplayName("생성한 Line Size 확인")
    void lineSize() {
        ladderLine = new LadderLine(countOfUser, () -> false);
        assertThat(ladderLine.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("임의의 Ladder Point 생성 - True")
    void ladderGenerateIsTrue() {
        ladderLine = new LadderLine(countOfUser, () -> true);
        assertThat(ladderLine.getPointIndex(0).isRight()).isTrue();
    }

    @Test
    @DisplayName("임의의 Ladder Point 생성 - False")
    void ladderGenerateIsFalse() {
        ladderLine = new LadderLine(countOfUser, () -> false);
        assertThat(ladderLine.getPointIndex(0).isRight()).isFalse();
    }

    @Test
    @DisplayName("1개의 라인 생성 및 사이즈 확인")
    void createLineSize() {
        ladderLine = new LadderLine(4, () -> false);
        assertThat(ladderLine.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("1개의 라인 생성")
    void createLine() {
        ladderLine = new LadderLine(4, () -> true);
        assertThat(ladderLine.getPointIndex(0).isRight()).isTrue();
    }

}
