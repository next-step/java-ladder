package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.domain.rule.AlwaysDrawingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    @DisplayName("사다리 게임이 잘 실행 되는지 확인")
    @Test
    public void ladderGameTest() {
        // given
        Players players = new Players("A,B,C");
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rows);

        // when
        Ladder ladder = ladderGame.make(new AlwaysDrawingRule());

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
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rows);

        // when
        Ladder ladder = ladderGame.make(() -> false);

        // then
        assertAll(
                () -> assertThat(ladder.getSizeOfPoints()).isEqualTo(players.getCountOfPlayers()),
                () -> assertThat(ladder.getRows()).hasSize(rows),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), FIRST_POINT)).isEqualTo(0),
                () -> assertThat(getHorizonLineCount(ladder.getRows(), SECOND_POINT)).isEqualTo(0)
        );
    }

    private int getHorizonLineCount(List<Row> rows, int ordinal) {
        return rows
                .stream()
                .mapToInt(r -> r.hasHorizonLine(ordinal) ? 1 : 0)
                .sum();
    }
}
