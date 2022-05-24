package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    private List<Line> lines;
    private Height height;

    @BeforeEach
    void setUp() {
        lines = List.of(
                Line.of(Arrays.asList(TRUE, TRUE, FALSE)),
                Line.of(Arrays.asList(FALSE, FALSE, TRUE))
        );

        height = Height.of(lines.get(0).height());
    }

    @Test
    void nameIsEmpty_ThrowException() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(LadderException.class);
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(LadderException.class);
    }

    @Test
    void nameLengthIsNotBetween1and5_ThrowException() {
        assertThatThrownBy(() -> new Player("abcedf"))
                .isInstanceOf(LadderException.class);
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(LadderException.class);
    }

    @DisplayName("각 선수가 본인 사다리게임을 실행 후 성공")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:0:3:X",
            "1:0:2:3:X",
            "2:0:1:3:3000"
    }, delimiter = ':')
    void move_success(int x, int y, int x1, int y1, String result) {
        Player jack = new Player("jack", Coordinate.of(x,y));
        jack.move(lines, height,  Arrays.asList("X", "3000", "X"));
        assertThat(jack).isEqualTo(new Player("jack", Coordinate.of(x1,y1), result));
    }

    @DisplayName("각 선수가 본인 사다리게임 실행하지만 실패")
    @Test
    void move_fail() {

    }
}
