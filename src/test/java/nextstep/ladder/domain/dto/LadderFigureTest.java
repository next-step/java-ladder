package nextstep.ladder.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFigureTest {
    @DisplayName("line right값 list와 함게 LadderFigure 생성한다")
    @Test
    public void make_LadderFigure() throws Exception {
        //arrange, act
        LadderFigure ladderFigure = LadderFigure.of(Arrays.asList(true, false));

        //assert
        assertThat(ladderFigure).isInstanceOf(LadderFigure.class);
    }

    @DisplayName("LadderFigure에서 lines 정보를 리턴한다")
    @Test
    public void should_return_ladder_lines_info() throws Exception {
        //arrange
        LadderFigure ladderFigure = LadderFigure.of(Arrays.asList(true, false));

        //act
        List<Boolean> lines = ladderFigure.getLines();

        //assert
        assertThat(lines).containsExactly(true, false);
    }
}