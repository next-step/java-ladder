package ladder.service;

import ladder.domain.LadderGame;
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
        LadderGame ladderGame = service.generateLadderGame("pobi,honux,crong,jk", 5);

        // then
        assertThat(4).isEqualTo(ladderGame.getParticipants().getCount());
    }

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 사다리 높이 검증")
    void ladderHeight() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when
        LadderGame ladderGame = service.generateLadderGame("pobi,honux,crong,jk", 5);

        // then
        assertThat(5).isEqualTo(ladderGame.getLineList().size());
    }

    @Test
    @DisplayName("참가자 정보 미입력")
    void participantsIsNull() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateLadderGame(null, 5))
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
                .isThrownBy(() -> service.generateLadderGame("pobi,honux,crong,jk", ladderHeight))
                .withMessageMatching("사다리의 높이는 최소 1 이상이어야 합니다.");
    }

}