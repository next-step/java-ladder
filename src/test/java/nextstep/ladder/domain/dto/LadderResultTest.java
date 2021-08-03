package nextstep.ladder.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @DisplayName("player names와 LadderFigure list로 LadderResult를 만든다")
    @Test
    public void make_LadderFigure() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("aa", "bbb");
        List<LadderFigure> figures = Arrays.asList(LadderFigure.of(Arrays.asList(true, false)));

        //act
        LadderResult ladderResult = LadderResult.of(playerNames, figures);

        //assert
        assertThat(ladderResult).isInstanceOf(LadderResult.class);
    }

    @DisplayName("LadderResult에서 player names를 반환한다")
    @Test
    public void should_return_players_names() throws Exception {
        //arrange
        List<String> playerNames = Arrays.asList("aa", "bbb");

        //act
        LadderResult ladderResult = LadderResult.of(playerNames, null);

        //assert
        assertThat(ladderResult.getPlayerNames()).containsAll(playerNames);
    }

    @DisplayName("LadderResult에서 LadderFigure를 반환한다")
    @Test
    public void should_return_figures() throws Exception {
        //arrange
        List<LadderFigure> figures = Arrays.asList(LadderFigure.of(Arrays.asList(true, false)));

        //act
        LadderResult ladderResult = LadderResult.of(null, figures);

        //assert
        assertThat(ladderResult.getLadderFigures()).containsAll(figures);
    }
}