package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Line line;
    private int countOfUser;

    @BeforeEach
    void setUp() {
        countOfUser = 4;
    }

    @Test
    @DisplayName("생성한 Line Size 확인")
    void lineSize() {
        line = new Line(countOfUser, new Point(), new LadderAutoGenerator());
        assertThat(line.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("임의의 Ladder Point 생성 - True")
    void ladderGenerateIsTrue() {
        line = new Line(countOfUser, new Point(), () -> true);
        assertThat(line.getPoint(0).isRight()).isTrue();
    }

    @Test
    @DisplayName("임의의 Ladder Point 생성 - False")
    void ladderGenerateIsFalse() {
        line = new Line(countOfUser, new Point(), () -> false);
        assertThat(line.getPoint(0).isRight()).isFalse();
    }

}
