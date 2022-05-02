package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리")
class LadderTest {

    private static final CustomEnvironment TWO_SIZE_ENVIRONMENT = CustomEnvironment.of(Participants.from(Arrays.asList("a", "b")), Results.from(Arrays.asList("100", "200")));
    private static final Lines TWO_HEIGHT_AND_POINTS_LINES = Lines.of(Positive.from(2), LineGenerator.of(Positive.from(2), () -> Point.CONNECTED));

    @Test
    @DisplayName("사용자 환경과 라인들로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES));
    }

    @Test
    @DisplayName("사용자 환경과 라인들은 필수")
    void instance_nullArguments_throwIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(null, TWO_HEIGHT_AND_POINTS_LINES));
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, null));
    }

    @Test
    @DisplayName("사용자 환경과 라인 포인트의 사이즈는 반드시 동일")
    void instance_differentSize_throwIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, Lines.of(Positive.from(2), LineGenerator.of(Positive.ONE, () -> Point.CONNECTED))));
    }

    @Test
    @DisplayName("주어진 사용자 환경 그대로 반환")
    void environment() {
        assertThat(Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES).environment()).isEqualTo(TWO_SIZE_ENVIRONMENT);
    }

    @Test
    @DisplayName("주어진 라인들 그대로 반환")
    void lines() {
        assertThat(Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES).lines()).isEqualTo(TWO_HEIGHT_AND_POINTS_LINES);
    }

    @Test
    @DisplayName("사용자의 정보로 결과 반환")
    void result() {
        //given
        Ladder twoSizeLadder = Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES);
        //when, then
        assertThat(twoSizeLadder.result(Participant.from("a"))).isEqualTo(Result.from("100"));
    }

    @Test
    @DisplayName("모든 참가자에 대한 결과")
    void participantResults() {
        //given
        Ladder twoSizeLadder = Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES);
        //when, then
        List<ParticipantResult> participantResults = twoSizeLadder.participantResults();
        assertThat(participantResults).containsExactly(
                ParticipantResult.of(Participant.from("a"), Result.from("100")),
                ParticipantResult.of(Participant.from("b"), Result.from("200"))
        );
    }
}
