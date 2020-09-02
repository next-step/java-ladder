package ladder.domain;

import ladder.domain.rule.AlwaysDrawRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    public static final int FIRST_POINT = 0;
    public static final int SECOND_POINT = 1;

    @Test
    @DisplayName("사다리 게임 실행 테스트")
    public void ladder_game_test() {
        // given
        Players players = Players.of("AAA,BBB,CCC");
        int lines = 5;
        LadderGame ladderGame = new LadderGame(players, lines);

        // when
        Ladder ladder = ladderGame.makeLadder(new AlwaysDrawRule());

        // then
        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(lines),
                () -> assertThat(ladder.getCountOfPoints()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(getLineCount(ladder.getLines(), FIRST_POINT)).isEqualTo(3),
                () -> assertThat(getLineCount(ladder.getLines(), SECOND_POINT)).isEqualTo(2)
        );
    }

    private int getLineCount(List<Line> rows, int point) {
        return rows
                .stream()
                .mapToInt(line -> line.hasLine(point) ? 1 : 0)
                .sum();
    }

}
