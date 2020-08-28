package camp.nextstep.edu.rebellion.game.custom;

import camp.nextstep.edu.rebellion.domain.position.MovedPositions;
import camp.nextstep.edu.rebellion.game.custom.Ladder;
import camp.nextstep.edu.rebellion.game.custom.Row;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import camp.nextstep.edu.rebellion.domain.rule.AlwaysDrawingRule;
import camp.nextstep.edu.rebellion.game.custom.CustomLadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CustomLadderGameTest {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    @DisplayName("사다리 게임이 잘 실행 되는지 확인")
    @Test
    public void ladderGameTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        CustomLadderGame customLadderGame = new CustomLadderGame(players, rows, new AlwaysDrawingRule());

        // when
        Ladder ladder = customLadderGame.getLadder();

        /*
        아래와 같은 사다리가 생성 됨
        A     B     C
        |-----|     |
        |     |-----|
        |-----|     |
        |     |-----|
        |-----|     |
         */

        // then
        assertAll(
                () -> assertThat(ladder.getSizeOfPoints()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(ladder.getRows()).hasSize(rows),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), FIRST_POINT)).isEqualTo(3),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), SECOND_POINT)).isEqualTo(2)
        );
    }

    @DisplayName("사다리 게임이 잘 실행 되는지 확인 (그리는 조건이 false 일 경우)")
    @Test
    public void ladderGameDrawingFalseTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        CustomLadderGame customLadderGame = new CustomLadderGame(players, rows, () -> false);

        // when
        Ladder ladder = customLadderGame.getLadder();

        // then
        assertAll(
                () -> assertThat(ladder.getSizeOfPoints()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(ladder.getRows()).hasSize(rows),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), FIRST_POINT)).isEqualTo(0),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), SECOND_POINT)).isEqualTo(0)
        );
    }

    @DisplayName("사다리 게임실행 결과가 잘 나오는지 확인 (이름으로 검색)")
    @Test
    public void runTest() {
        // given
        Players players = new Players("A,B,C");
        int rows = 5;
        CustomLadderGame customLadderGame = new CustomLadderGame(players, rows, new AlwaysDrawingRule());
        /*
        아래와 같은 사다리가 생성 됨
        A     B     C
        |-----|     |
        |     |-----|
        |-----|     |
        |     |-----|
        |-----|     |
        P0    P1    P2
         */

        // when
        MovedPositions positions = customLadderGame.run("A");

        // then
        assertAll(
                () -> assertThat(positions.getPositions()).hasSize(1),
                () -> assertThat(positions.getPositions().get(0).getName()).isEqualTo("A"),
                () -> assertThat(positions.getPositions().get(0).getFinalPosition()).isEqualTo(0)
        );
    }

    @DisplayName("사다리 게임실행 결과가 잘 나오는지 확인 (all 검색)")
    @Test
    public void runAllTest() {
        // given
        Players players = new Players("A,B,C");
        int rows = 5;
        CustomLadderGame customLadderGame = new CustomLadderGame(players, rows, new AlwaysDrawingRule());
        /*
        아래와 같은 사다리가 생성 됨
        A     B     C
        |-----|     |
        |     |-----|
        |-----|     |
        |     |-----|
        |-----|     |
         */

        // when
        MovedPositions positions = customLadderGame.run("all");

        // then
        assertAll(
                () -> assertThat(positions.getPositions()).hasSize(3),
                () -> assertThat(positions.getPositions().get(0).getName()).isEqualTo("A"),
                () -> assertThat(positions.getPositions().get(0).getFinalPosition()).isEqualTo(0),
                () -> assertThat(positions.getPositions().get(1).getName()).isEqualTo("B"),
                () -> assertThat(positions.getPositions().get(1).getFinalPosition()).isEqualTo(2),
                () -> assertThat(positions.getPositions().get(2).getName()).isEqualTo("C"),
                () -> assertThat(positions.getPositions().get(2).getFinalPosition()).isEqualTo(1)
        );
    }

    private int getHorizonLineCount(List<Row> rows, int ordinal) {
        return rows
                .stream()
                .mapToInt(r -> r.hasHorizonLine(ordinal) ? 1 : 0)
                .sum();
    }
}
