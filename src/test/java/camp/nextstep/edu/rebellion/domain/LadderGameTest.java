package camp.nextstep.edu.rebellion.domain;

import camp.nextstep.edu.rebellion.domain.ladder.Ladder;
import camp.nextstep.edu.rebellion.domain.ladder.Row;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import camp.nextstep.edu.rebellion.domain.rule.AlwaysDrawingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;

    @DisplayName("사다리 게임이 잘 실행 되는지 확인")
    @Test
    public void ladderGameTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rewards, rows);

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
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rewards, rows);

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

    @DisplayName("참가자 수와 당첨결과 수가 일치 하지 않을 경우 사다리 게임 생성 안됨")
    @Test
    public void ladderGameThrownTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("꽝");
        int rows = 5;

        // when & then
        assertThatThrownBy(() -> new LadderGame(players, rewards, rows))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수와 당첨결과 수가 일치하지 않습니다");
    }

    @DisplayName("사다리 게임실행 결과가 잘 나오는지 확인 (이름으로 검색)")
    @Test
    public void runTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rewards, rows);
        ladderGame.make(new AlwaysDrawingRule());
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
        RewardResults results = ladderGame.run("A");

        // then
        assertAll(
                () -> assertThat(results.getRewardResults()).hasSize(1),
                () -> assertThat(results.getRewardResults().get(0).getName()).isEqualTo("A"),
                () -> assertThat(results.getRewardResults().get(0).getReward()).isEqualTo("1등")
        );
    }

    @DisplayName("사다리 게임실행 결과가 잘 나오는지 확인 (all 검색)")
    @Test
    public void runAllTest() {
        // given
        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1등,2등,꽝");
        int rows = 5;
        LadderGame ladderGame = new LadderGame(players, rewards, rows);
        ladderGame.make(new AlwaysDrawingRule());
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
        RewardResults results = ladderGame.run("all");

        // then
        assertAll(
                () -> assertThat(results.getRewardResults()).hasSize(3),
                () -> assertThat(results.getRewardResults().get(0).getName()).isEqualTo("A"),
                () -> assertThat(results.getRewardResults().get(0).getReward()).isEqualTo("1등"),
                () -> assertThat(results.getRewardResults().get(1).getName()).isEqualTo("B"),
                () -> assertThat(results.getRewardResults().get(1).getReward()).isEqualTo("꽝"),
                () -> assertThat(results.getRewardResults().get(2).getName()).isEqualTo("C"),
                () -> assertThat(results.getRewardResults().get(2).getReward()).isEqualTo("2등")
        );
    }

    private int getHorizonLineCount(List<Row> rows, int ordinal) {
        return rows
                .stream()
                .mapToInt(r -> r.hasHorizonLine(ordinal) ? 1 : 0)
                .sum();
    }
}
