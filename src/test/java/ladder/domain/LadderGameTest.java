package ladder.domain;

import ladder.domain.rule.DrawRule;
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
        Rewards rewards = Rewards.builder()
                .rewardInput("꽝,10000,5000")
                .countOfPlayers(3)
                .build();

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(rows)
                .rewards(rewards)
                .build();

        DrawRule alwaysDrawRule = () -> true;

        // when
        Ladder ladder = ladderGame.makeLadder(alwaysDrawRule);

        // then
        assertAll(
                () -> assertThat(ladder.getRows()).hasSize(rows),
                () -> assertThat(ladder.getCountOfColumn()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(getLineCount(ladder.getRows(), FIRST_COLUMN)).isEqualTo(5),
                () -> assertThat(getLineCount(ladder.getRows(), SECOND_COLUMN)).isEqualTo(0)
        );
    }

    private int getLineCount(List<Row> rows, int column) {
        return rows
                .stream()
                .mapToInt(row -> row.hasLine(column) ? 1 : 0)
                .sum();
    }

}
