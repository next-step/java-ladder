package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Line line;

    @BeforeEach
    void init() {
        line = new Line(3, drawLineRandomMock());

        // true, false, true
        /* 0     1      2     3
           |-----|      |-----|
         */
    }

    @Test
    @DisplayName("Position 생성이 정상적으로 수행되어야 한다.")
    void create() {
        assertThatCode(() -> Position.of(0)).doesNotThrowAnyException();
        assertThatCode(() -> Position.of(1)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Position 생성시, 음수가 들어가면 에러가 발생한다.")
    void name() {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.of(-1));
    }

    @Test
    @DisplayName("사다리 선에 따라, 정상적으로 이동한다.")
    void lineMoveTest() {
        assertThat(Position.of(0).move(line)).isEqualTo(Position.of(1));
        assertThat(Position.of(1).move(line)).isEqualTo(Position.of(0));
        assertThat(Position.of(2).move(line)).isEqualTo(Position.of(3));
    }


    private Random drawLineRandomMock() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }

}