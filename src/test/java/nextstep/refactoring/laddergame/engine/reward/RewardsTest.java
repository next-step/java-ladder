package nextstep.refactoring.laddergame.engine.reward;

import nextstep.refactoring.ladder.concrete.TestLadder;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RewardsTest {

    static Rewards rewards() {
        return Rewards.of("1000", "2000", "3000", "4000", "5000");
    }

    @Test
    @DisplayName("특정 위치에 있는 보상을 가져온다.")
    void getRewards() {
        Rewards rewards = rewards();

        assertThat(rewards.get(Position.of(2))).isEqualTo(Reward.of("3000", 2));
    }

    @Test
    @DisplayName("범위를 넘어선 위치에서 보상 정보를 가져오려고 시도하면 예외 처리한다.")
    void throwExceptionIfPositionExceedRewardsSize() {
        Rewards rewards = rewards();

        assertThatThrownBy(() -> rewards.get(Position.of(5)))
            .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("사다리의 지점 개수와 요소 개수가 같은지 비교하여 사다리와 호환 불가능한지 파악한다.")
    void checkIfNotCompatible() {
        Rewards fiveRewards = rewards();
        Rewards fourRewards = Rewards.of("꽝", "5000", "꽝", "3000");
        Ladder ladder = TestLadder.ladder();

        assertAll(
            () -> assertThat(fiveRewards.isNotCompatible(ladder)).isTrue(),
            () -> assertThat(fourRewards.isNotCompatible(ladder)).isFalse()
        );
    }

}
