package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGenerationServiceTest {

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 참가자 수 검증")
    void participantCount() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when
        Participants participants = service.registerParticipants("pobi,honux,crong,jk");

        // then
        assertThat(4).isEqualTo(participants.getCount());
    }

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 사다리 높이 검증")
    void ladderHeight() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when
        Ladder ladder = service.generateLadder(4, 5);

        // then
        assertThat(5).isEqualTo(ladder.getLines().size());
    }

    @Test
    @DisplayName("참가자 정보 미입력")
    void participantsIsNull() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.registerParticipants(null))
                .withMessageMatching("참가자 이름을 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("사다리 높이")
    void validateLadderHeight(int ladderHeight) {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateLadder(4, ladderHeight))
                .withMessageMatching("사다리의 높이는 최소 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1})
    @DisplayName("사다리 너비")
    void validateLadderWidth(int ladderWidth) {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateLadder(ladderWidth, 5))
                .withMessageMatching("사다리의 너비는 최소 2 이상이어야 합니다.");
    }

}