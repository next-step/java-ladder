package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        final List<String> participantNames = Arrays.asList("1", "2", "3");
        final List<String> rewardNames = Arrays.asList("1", "2", "3");
        ladderGame = new LadderGame(participantNames, rewardNames);
    }

    @Test
    @DisplayName("LadderGame은 참가자들과 보상 리스트로 생성된다.")
    void new_LadderGame() {
        assertThat(ladderGame).isInstanceOf(LadderGame.class);
    }

    @Test
    @DisplayName("LadderGame은 참가자의 수와 보상의 수가 다르면 예외를 발생한다.")
    void new_WithDifferenceOfParticipantsAndRewards_ExceptionThrown() {
        final List<String> participantNames = Arrays.asList("1", "2", "3");
        final List<String> rewardNames = Arrays.asList("1", "2", "3", "4");

        assertThatThrownBy(() -> new LadderGame(participantNames, rewardNames))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("initGame 메서드는 사다리를 생성한다.")
    void initGame_LadderCreated() {
        assertThat(ladderGame.initGame(5)).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("run 메서드는 사다리 게임 결과를 반환한다.")
    void run_Result() {
        final Ladder ladder = ladderGame.initGame(5);
        assertThat(ladderGame.run(ladder)).isInstanceOf(Result.class);
    }
}
