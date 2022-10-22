package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameTest {

    private final ParticipantNames participantNames = ParticipantNames.from(List.of("a", "ab", "abc"));

    private final List<LadderGameReward> rewards = List.of(
            new LadderGameReward("꽝"),
            new LadderGameReward("꽝2"),
            new LadderGameReward("당첨")
    );

    private final Ladder ladder = new Ladder(List.of(
            new LadderLine(List.of(false, true)),
            new LadderLine(List.of(true, false)),
            new LadderLine(List.of(true, false))
    ));

    @DisplayName("참가자 이름의 수와 사다리 게임 결과의 수가 같지 않으면, 예외가 발생해야 한다.")
    @Test
    void create_whenNotMatchNumberOfParticipantNamesAndNumberOfRewards() {
        ParticipantNames participantNames = ParticipantNames.from(List.of("a", "ab"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(participantNames, rewards, ladder));
    }

    @DisplayName("참가자 이름의 수가 사다리의 가로 길이 + 1 와 같지 않다면, 예외가 발생해야 한다.")
    @Test
    void create_whenNotMatchNumberOfParticipantNamesAndLadderWidthPlusOne() {
        Ladder ladder = new Ladder(List.of(
                new LadderLine(List.of(false)),
                new LadderLine(List.of(true)),
                new LadderLine(List.of(true))
        ));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(participantNames, rewards, ladder));
    }

    @DisplayName("사다리 게임 최종 결과를 반환해야 한다.")
    @Test
    void calculateRewardByParticipantName() {
        LadderGame ladderGame = new LadderGame(participantNames, rewards, ladder);
        assertThat(ladderGame.calculateRewardByParticipantName())
                .isEqualTo(Map.of(
                        new ParticipantName("a"), new LadderGameReward("꽝"),
                        new ParticipantName("ab"), new LadderGameReward("당첨"),
                        new ParticipantName("abc"), new LadderGameReward("꽝2")
                ));
    }

}
