package ladder.domain;

import ladder.domain.rule.DrawRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    public static final int FIRST_ROW = 0;
    public static final int SECOND_ROW = 1;

    @Test
    @DisplayName("사다리 게임 실행 테스트")
    public void ladder_game_test() {
        // given
        Players players = Players.of("AAA,BBB,CCC");
        int lines = 5;
        DrawRule alwaysDrawRule = () -> true;
        LadderGame ladderGame = new LadderGame(players, lines);

        // when
        Ladder ladder = ladderGame.makeLadder(alwaysDrawRule);

        // then
        assertAll(
                () -> assertThat(ladder.getRows()).hasSize(lines),
                () -> assertThat(ladder.getCountOfColumn()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(getLineCount(ladder.getRows(), FIRST_ROW)).isEqualTo(3),
                () -> assertThat(getLineCount(ladder.getRows(), SECOND_ROW)).isEqualTo(2)
        );
    }

    private int getLineCount(List<Row> rows, int point) {
        return rows
                .stream()
                .mapToInt(line -> line.hasLine(point) ? 1 : 0)
                .sum();
    }

}
