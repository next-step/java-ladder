package ladder.game;

import ladder.domain.player.Players;
import ladder.domain.rule.DrawRule;
import ladder.game.Ladder;
import ladder.game.LadderGame;
import ladder.tdd.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    public static final int FIRST_COLUMN = 0;
    public static final int SECOND_COLUMN= 1;

    @Test
    @DisplayName("사다리 게임 실행 테스트")
    public void ladder_game_test() {
        // given
        Players players = Players.of("AAA,BBB,CCC");
        int rows = 5;

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(rows)
                .build();

        DrawRule alwaysDrawRule = () -> true;

        // when
        Ladder ladder = ladderGame.makeLadder(alwaysDrawRule);

        // then
        assertAll(
                () -> assertThat(ladder.getLadderLines()).hasSize(rows),
                () -> assertThat(ladder.getCountOfColumn()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(getLineCount(ladder.getLadderLines(), FIRST_COLUMN)).isEqualTo(5),
                () -> assertThat(getLineCount(ladder.getLadderLines(), SECOND_COLUMN)).isEqualTo(0)
        );
    }

    private int getLineCount(List<LadderLine> ladderLines, int column) {
        return ladderLines
                .stream()
                .mapToInt(ladderLine -> ladderLine.hasLine(column) ? 1 : 0)
                .sum();
    }

}
