package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("사다리 generate 동작 확인 - 정상")
    void test_generate() {
        Ladder ladder = Ladder.generate(2, 3, new RandomConnectionStrategy());
        assertThat(ladder).isInstanceOf(Ladder.class);
        assertThat(ladder.asList()).hasSize(2);
        assertThat(ladder.asList().get(0).asList()).hasSize(3);
    }

    @Test
    @DisplayName("사다리 generate에 사다리 높이를 1보다 적게 설정 한 경우 - 예외 발생")
    void generate_with_wrong_height() {
        assertThatThrownBy(() -> Ladder.generate(0, 2, new RandomConnectionStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.INVALID_LADDER_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("사다리 generate에 사다리 width를 2보다 적게 설정 한 경우 - 예외 발생")
    void generate_with_wrong_size() {
        assertThatThrownBy(() -> Ladder.generate(2, 1, new RandomConnectionStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.INVALID_LADDER_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("사다리게임 결과 매칭시 참가자 수와 결과 수가 일치하지 않는 경우 - 예외 발생")
    void assign_rewards_with_not_match_participants_rewards() {
        Participants participants = new Participants(List.of(new Name("a"), new Name("b")));
        Rewards rewards = new Rewards(List.of(new Name("1000"), new Name("2000"), new Name("3000")));
        Ladder ladder = Ladder.generate(2, 2, new RandomConnectionStrategy());
        assertThatThrownBy(() -> ladder.assignRewards(participants, rewards))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.NOT_MATCH_PARTICIPANTS_REWARDS_COUNT);
    }

    @Test
    @DisplayName("사다리게임 결과 매칭 동작 확인")
    void assign_rewards() {
        Participants participants = new Participants(List.of(new Name("a"), new Name("b"), new Name("c")));
        Rewards rewards = new Rewards(List.of(new Name("1000"), new Name("2000"), new Name("3000")));
        /*
            아래 형태를 가지는 bridge를 생성
            |---|   |
            |   |---|
         */
        Ladder ladder = Ladder.generate(2, 3, new RepeatingConnectionStrategy());
        LadderResults ladderResults = ladder.assignRewards(participants, rewards);
        assertThat(ladderResults.resultOf("a")).isEqualTo(new Name("3000"));
        assertThat(ladderResults.resultOf("b")).isEqualTo(new Name("1000"));
        assertThat(ladderResults.resultOf("c")).isEqualTo(new Name("2000"));
    }
}
