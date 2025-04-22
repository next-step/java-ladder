package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    List<LadderLine> ladderLines;

    @BeforeEach
    void setUp() {
        /*
            아래 형태를 가지는 bridge를 생성
            |---|   |
            |   |---|
         */
        List<Bridge> bridge1 = List.of(new Bridge(false, true), new Bridge(true, false), new Bridge(false, false));
        List<Bridge> bridge2 = List.of(new Bridge(false, false), new Bridge(false, true), new Bridge(true, false));
        ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(bridge1));
        ladderLines.add(new LadderLine(bridge2));
    }

    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        Ladder ladder = new Ladder(ladderLines);
        assertThat(ladder.asList()).isEqualTo(ladderLines);
    }

    @Test
    @DisplayName("기본 생성자에 참여자 숫자와 맞지 않는 사다리 입력시 동작 확인 - 예외 발생")
    void create_with_no_match_participants_and_lines() {
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.generate(2));
        ladderLines.add(LadderLine.generate(3));

        assertThatThrownBy(() -> new Ladder(ladderLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.NOT_ALL_MATCH_LADDER_SIZE);
    }

    @Test
    @DisplayName("사다리 generate에 사다리 높이를 1보다 적게 설정 한 경우 - 예외 발생")
    void generate_with_wrong_height() {
        assertThatThrownBy(() -> Ladder.generate(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.INVALID_LADDER_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("사다리 generate에 사다리 갯수를 1보다 적게 설정 한 경우 - 예외 발생")
    void generate_with_wrong_size() {
        assertThatThrownBy(() -> Ladder.generate(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.INVALID_LADDER_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("사다리게임 결과 매칭시 참가자 수와 결과 수가 일치하지 않는 경우 - 예외 발생")
    void assign_rewards_with_not_match_participants_rewards() {
        Participants participants = new Participants(List.of(new Name("a"), new Name("b")));
        Rewards rewards = new Rewards(List.of(new Name("1000"), new Name("2000"), new Name("3000")));
        Ladder ladder = Ladder.generate(2, 2);
        assertThatThrownBy(() -> ladder.assignRewards(participants, rewards))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.NOT_MATCH_PARTICIPANTS_REWARDS_COUNT);
    }

    @Test
    @DisplayName("사다리게임 결과 매칭 동작 확인")
    void assign_rewards() {
        Participants participants = new Participants(List.of(new Name("a"), new Name("b"), new Name("c")));
        Rewards rewards = new Rewards(List.of(new Name("1000"), new Name("2000"), new Name("3000")));
        Ladder ladder = new Ladder(ladderLines);
        LadderResults ladderResults = ladder.assignRewards(participants, rewards);
        assertThat(ladderResults.resultOf("a")).isEqualTo(new Name("3000"));
        assertThat(ladderResults.resultOf("b")).isEqualTo(new Name("1000"));
        assertThat(ladderResults.resultOf("c")).isEqualTo(new Name("2000"));
    }
}
