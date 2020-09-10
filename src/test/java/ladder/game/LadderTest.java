package ladder.game;

import ladder.domain.player.Players;
import ladder.domain.rule.DrawRule;
import ladder.game.Ladder;
import ladder.game.LadderGame;
import ladder.tdd.LadderLine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderTest {

    private Ladder ladder;

    @BeforeAll
    public void setup() {
        int rowCount = 4;
        Players players = Players.of("AAA,BBB,CCC");
        DrawRule alwaysDrawRule = () -> true;

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(rowCount)
                .build();

        ladder = ladderGame.makeLadder(alwaysDrawRule);
    }

    @Test
    @DisplayName("위치에 Line이 잘 생성되는지 확인")
    public void ladder_draw_line_test() {
        // given
        int curColumn = 0;

        // when
        LadderLine ladderLine = ladder.getLadderLines().get(0);

        // then
        assertThat(ladderLine.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("같은 Row에서 인접하게 Line이 생성되지 않는 테스트")
    public void draw_adjacent_line_test() {
        // given
        int curRow = 0;
        int nextColumn = 1;

        // when
        LadderLine ladderLine = ladder.getLadderLines().get(curRow);

        // then
        assertThat(ladderLine.hasLine(nextColumn)).isFalse();
    }

    @Test
    @DisplayName("사다리 길찾기 테스트")
    public void search_line_test() {
        assertThat(ladder.searchFinalPosition(1)).isEqualTo(1);
        assertThat(ladder.searchFinalPosition(2)).isEqualTo(2);
    }

}
